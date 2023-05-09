package company.aria.mypage.controller;

import java.util.HashMap;

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
import org.springframework.web.servlet.ModelAndView;

import company.aria.member.vo.MemberVO;
import company.aria.mypage.service.MyPageService;

@Controller("MypageController")
@RequestMapping(value="/mypage")
public class MypageController {
	@Autowired
	private MemberVO memberVO;
	
	@Autowired
	private MyPageService mypageService;
	
	@RequestMapping(value="/myPageMain.do" ,method = RequestMethod.GET)
	public ModelAndView myPageMain(@RequestParam(required = false,value="message")  String message,
			   HttpServletRequest request, HttpServletResponse response)  throws Exception {
		HttpSession session=request.getSession();
		session=request.getSession();
		session.setAttribute("side_menu", "my_page"); 
		
		String viewName=(String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		memberVO=(MemberVO)session.getAttribute("memberInfo");
		String member_id=memberVO.getMe_id();
		
		
		mav.addObject("message", message);

		return mav;
	}
	
	@RequestMapping(value="/modmember.do" ,method = RequestMethod.GET)
	public ModelAndView modmember(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		String viewName=(String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	
	}
	
	@RequestMapping(value="/modbu.do" ,method = RequestMethod.GET)
	public ModelAndView modbu(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		String viewName=(String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	
	}
	
	@RequestMapping(value="/updateMember.do" ,method = RequestMethod.POST)
	public ResponseEntity updateMember(@ModelAttribute("memberVO") MemberVO _memberVO,
			                HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
		    mypageService.updateMember(_memberVO);
		    message  = "<script>";
		    message +=" alert('회원정보 수정이 완료되었습니다.');";
		    message += " location.href='"+request.getContextPath()+"/mypage/myPageMain.do';";
		    message += " </script>";
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert(ּ'작업에 실패했습니다. 다시 시도해주세요.');";
		    message += " location.href='"+request.getContextPath()+"/mypage/modmember.do';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
	
	@RequestMapping(value="/deletemember.do" ,method = RequestMethod.POST)
	   public ModelAndView deletemember(@RequestParam("login_id")  String login_id,HttpServletRequest request, HttpServletResponse response)  throws Exception {
	      HttpSession session=request.getSession();
	      session.setAttribute("isLogOn", false);
	      mypageService.deletemember(login_id);
	      ModelAndView mav = new ModelAndView("redirect:/main/main.do");
	      return mav;
	   }
	
	@RequestMapping(value="/addcard.do" ,method = RequestMethod.GET)
	public ModelAndView addcard(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		String viewName=(String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	
	}
	
	@RequestMapping(value="/updatecard.do" ,method = RequestMethod.POST)
	public ResponseEntity updatecard(@RequestParam("me_cardNo") String me_cardNo,
			                HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String login_id = (String)session.getAttribute("login_id");
		
		HashMap map = new HashMap();
		map.put("me_cardNo", me_cardNo);
		map.put("login_id", login_id);
		int result = 0;
		result = mypageService.updatecard(map);
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		resEntity =new ResponseEntity(result,responseHeaders, HttpStatus.OK);
		return resEntity;
	}
	
}
