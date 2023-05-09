package company.aria.kakaomsg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import company.aria.oauth.OAuthController;

@Controller("kakaoMsgController")
public class KakaoMsgController {
	@Autowired
	private OAuthController oauthController;
	@Autowired
	private KakaoMsgService kakaoMsgService;
	
	@RequestMapping(value="/kakaoMsg/send.do", method=RequestMethod.POST)
	public ResponseEntity sendMsg(HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		ResponseEntity resEntity = null;
		String message = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8;");
		
		String sendTo = (String)request.getParameter("sendTo");
		String sendMsg = (String)request.getParameter("sendMsg");
		HttpSession session = request.getSession();
		String access_Token = (String)session.getAttribute("access_Token");
		HashMap accessMap = new HashMap();
		accessMap.put("sendTo", sendTo);
		accessMap.put("sendMsg", sendMsg);
		accessMap.put("access_Token", access_Token);
		
		kakaoMsgService.sendMsgByAccessToken(accessMap);
			
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
		
		
	}
	@RequestMapping(value="/kakaoMsg/sendToFriends.do", method=RequestMethod.POST)
	public ResponseEntity sendMsgFriends(@RequestParam("sendTo") String sendTo, @RequestParam("sendMsg") String sendMsg, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		ResponseEntity resEntity = null;
		String message = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8;");
		HttpSession session = request.getSession();
		try {
		String access_Token = (String)session.getAttribute("access_Token");
		List<HashMap> friendsList = (List)session.getAttribute("friendsList");
		
		String nickname;
		String uuid="";
		HashMap accessMap = new HashMap();
		Iterator<HashMap> iterator = friendsList.iterator();
		while(iterator.hasNext()) {
			HashMap entry = iterator.next();
			nickname = (String) entry.get("nickname");
			if(nickname.equals(sendTo)) uuid = (String) entry.get("uuid");
			if(!(uuid.equals("")) && uuid!=null) {
				accessMap.put("sendTo", sendTo);
				accessMap.put("sendUuid", uuid);
				accessMap.put("sendMsg", sendMsg);
				accessMap.put("access_Token", access_Token);
				kakaoMsgService.sendMsgFriendsByAccessToken(accessMap);
				break;
			}
		}
		message+="<script>";
		message+="alert('친구에게 메시지 전송이 완료되었습니다.');";
		//message+="location.href='"+request.getContextPath()+"/test/testPage.do';";
		message+="</script>";
		}catch(Exception e) {
			e.printStackTrace();
			message+="<script>";
			message+="alert('친구에게 메시지 전송이 실패했습니다.');";
			message+="</script>";
		}finally {
		session.removeAttribute("friendsList");
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
		}
	}
	
	@RequestMapping(value="/kakaoMsg/callKakaoFriends.do", method=RequestMethod.POST)
	public ModelAndView callKakaoFriends(HttpServletRequest request, HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:/test/testPage.do");
		HttpSession session = request.getSession();
		String access_Token = (String)session.getAttribute("access_Token");
		
		//Security//
		//List viewFriendsMap = new ArrayList();
		List friendsList = kakaoMsgService.callKakaoFriends(access_Token);
		session.setAttribute("friendsList", friendsList);
		
		List<HashMap> viewFriendsList = new ArrayList();
		Iterator<HashMap> iterator = friendsList.iterator();
		while(iterator.hasNext()) {
			HashMap entry = iterator.next();
			HashMap viewFriend = new HashMap();
			//String uuid = (String)iterator.next().get("uuid");
			String nickname = (String)entry.get("nickname");
			String id = (String)entry.get("id");
			viewFriend.put("nickname", nickname);
			viewFriend.put("id", id);
			viewFriendsList.add(viewFriend);
		}
		mav.addObject("viewFriendsList", viewFriendsList);

		return mav;
	}

}
