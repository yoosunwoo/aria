package company.aria.oauth;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import company.aria.member.service.MemberService;
import company.aria.member.vo.MemberVO;


@RestController
@Controller("OAuthController")
//@RequestMapping(value="/LoginOAuth")
public class OAuthController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO;
	@Autowired
	private OAuthService oauthService;
	
	@ResponseBody
	@RequestMapping(value="/loginOAuth")
	public ResponseEntity kakaoCallback(@RequestParam String code, HttpServletRequest request, HttpServletResponse response)throws Exception {
		HashMap properties = new HashMap();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		String message = "";
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type","text/html; charset=utf-8;");
		
		HttpSession session = request.getSession();
		
		try {
		System.out.println("\t code : "+code);
        String access_Token = oauthService.getKakaoAccessToken(code);
        System.out.println("\t access_Token(Controller) : "+access_Token);
        session.setAttribute("access_Token", access_Token);
        
        properties = oauthService.getPropertyByAccessToken(access_Token);
        Iterator<Entry> entries = properties.entrySet().iterator();
        while(entries.hasNext()) {
        	HashMap.Entry entry = entries.next();
        	System.out.println("[key] : "+entry.getKey()+" [value] : "+entry.getValue());
        }//end while
        
        //check properties
        if(!(properties.isEmpty())) {
        	System.out.println("----------Success get property of kakao----------");
        	HashMap resultMap = new HashMap();
        	resultMap = memberService.confirmMember(properties);
        	int resultMsg = (Integer) resultMap.get("resultMsg");
        	
        	System.out.println("\t resultMsg : "+resultMsg);

        	//resultMsg [0] : error / [1] : already existed kakao_id / [2] : not existed kakao_id / [3] : is not member
        	if(resultMsg == 1) {
        		MemberVO memberInfoAdd = (MemberVO) resultMap.get("memberVO");
        		MemberVO memberVO = loginKakaoPrepare(memberInfoAdd);
				
        		//Exit kakaoCallback for already logOn
        		if((Boolean)session.getAttribute("isLogOn")) {
        			session.setAttribute("kakaoMemberInfo",memberVO);
        			message+="<script>";
        			message+="alert('카카오 로그인이 완료되었습니다.');";
        			message+="location.href='"+request.getContextPath()+"/test/testPage.do';";
        			//message+="location.href='"+request.getRequestURI()+"';";
        			//message+="location.reload()";
        			message+="</script>";
        		}else {
        	
        		session.setAttribute("isLogOn", true);
				session.setAttribute("memberInfo",memberVO);
				
        		message+="<script>";
    			message+="alert('카카오 간편 로그인이 완료되었습니다.');";
    			message+="location.href='"+request.getContextPath()+"/main/main.do';";
    			message+="</script>";
        		}
        		
        	}else if(resultMsg == 2) {
        		MemberVO memberInfoAdd = (MemberVO) resultMap.get("memberVO");
        		session.setAttribute("properties", properties);
        		session.setAttribute("memberInfoAdd", memberInfoAdd);
        		message+="<script>";
    			message+="alert('기존 회원에 카카오 연동이 되어 있지 않습니다.');";
    			message+="location.href='"+request.getContextPath()+"/loginOAuth/memberFormAdd.do';";
    			message+="</script>";
        	}else if(resultMsg == 3){
        		session.setAttribute("properties", properties);
        		message+="<script>";
    			message+="alert('카카오 연결이 완료되었습니다.');";
    			message+="location.href='"+request.getContextPath()+"/loginOAuth/memberFormAdd.do';";
    			message+="</script>";
        	}

        }else {
        	System.out.println("----------Empty get property of kakao----------");
        	
        	message+="<script>";
			message+="alert('가져올 카카오 로그인 정보가 없습니다.');";
			message+="location.href='"+request.getContextPath()+"/member/login.do';";
			message+="</script>";
        }
        
		}catch(Exception e) {
			message+="<script>";
			message+="alert('카카오 로그인 연동에 실패했습니다. 자세한 사항은 관리자에게 연락하세요.');";
			message+="location.href='"+request.getContextPath()+"/member/login.do';";
			message+="</script>";
			e.printStackTrace();
		}finally {
			//properties.clear();
			resEntity = new ResponseEntity(message,responseHeaders,HttpStatus.OK);
			return resEntity;
		}

    }
	@RequestMapping(value="/loginOAuth/memberFormAdd.do", method=RequestMethod.GET)
	public ModelAndView additionalMemberForm(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView();
		String viewName = (String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		//Session Check
		//HttpSession session = request.getSession();
		//HashMap properties = (HashMap) session.getAttribute("properties");
		//System.out.println("\t additionalMemberForm session : "+session.getAttribute("properties"));
		return mav;
	}
	@RequestMapping(value="/loginOAuth/addMemberByKakao.do", method=RequestMethod.POST)
	public ResponseEntity addMemberByKakao(@ModelAttribute("memberVO") MemberVO _memberVO, HttpServletRequest request,HttpServletResponse response)throws Exception{
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		//System.out.println("\t id check "+_memberVO.getMe_id());
		
		HttpSession session = request.getSession();
		HashMap properties = (HashMap)session.getAttribute("properties");
		//System.out.println("\t session check - kakao properties at addMemberByKakao"+properties);
		try {
			int result = memberService.addMemberByKakao(_memberVO, properties);
			
			//System.out.println("\t check result : "+result);
			if(result == 1) { //result [1] : success / [0] : fail
				MemberVO memberVO = loginKakaoPrepare(_memberVO);
				//String login_id = memberVO.getMe_id();
				//session.setAttribute("login_id", login_id);
				session.setAttribute("isLogOn", true);
				session.setAttribute("memberInfo",memberVO);
				
				message  = "<script>";
				message +=" alert('회원가입 처리가 완료되었습니다.');";
				message += " location.href='"+request.getContextPath()+"/main/main.do';";
				message += " </script>";
			}else {
				message  = "<script>";
			    message +=" alert('회원가입 처리가 정상적으로 진행되지 않았습니다. 관리자에게 연락하세요');";
			    message += " location.href='"+request.getContextPath()+"/member/login.do';";
			    message += " </script>";
			}
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('회원가입 처리가 실패했습니다. 관리자에게 연락하세요');";
		    message += " location.href='"+request.getContextPath()+"/member/login.do';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
	@RequestMapping(value="/loginOAuth/updateMemberByKakao.do", method=RequestMethod.POST)
	public ResponseEntity updateMemberByKakao(@ModelAttribute("memberVO") MemberVO _memberVO, HttpServletRequest request,HttpServletResponse response)throws Exception{
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		//System.out.println("\t id check "+_memberVO.getMe_id());
		
		HttpSession session = request.getSession();
		HashMap properties = (HashMap)session.getAttribute("properties");
		//System.out.println("\t session check - kakao properties at addMemberByKakao"+properties);
		try {
			int result = memberService.updateMemberByKakao(_memberVO, properties);
			
			//System.out.println("\t check result : "+result);
			if(result == 1) { //result [1] : success / [0] : fail
				MemberVO memberVO = loginKakaoPrepare(_memberVO);
				//String login_id = memberVO.getMe_id();
				//session.setAttribute("login_id", login_id);
				session.setAttribute("isLogOn", true);
				session.setAttribute("memberInfo",memberVO);
				
				message  = "<script>";
				message +=" alert('기존 회원정보에 카카오로그인이 연동되었습니다.');";
				message += " location.href='"+request.getContextPath()+"/main/main.do';";
				message += " </script>";
			}else {
				message  = "<script>";
			    message +=" alert('연동이 실패했습니다. 관리자에게 연락하세요');";
			    message += " location.href='"+request.getContextPath()+"/member/login.do';";
			    message += " </script>";
			}
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('회원가입 처리가 실패했습니다. 관리자에게 연락하세요');";
		    message += " location.href='"+request.getContextPath()+"/member/login.do';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
	private MemberVO loginKakaoPrepare(MemberVO _memberVO)throws Exception{
		HashMap loginMap = new HashMap();
		loginMap.put("me_id", _memberVO.getMe_id());
		loginMap.put("me_pw", _memberVO.getMe_pw());
		MemberVO memberVO = memberService.login(loginMap);
		return memberVO;
	}
	
}