package company.aria.inquiry.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import company.aria.common.base.BaseController;
import company.aria.member.vo.MemberVO;

@Controller("inquiryController")
@RequestMapping(value="/inquiry")
public class InquiryController extends BaseController {
	
	@Autowired
	private MemberVO memberVO;
	
	@RequestMapping(value="/iq-add.do" ,method = RequestMethod.GET)
	public ModelAndView myPageMain(@RequestParam(required = false,value="message")  String message,
			   HttpServletRequest request, HttpServletResponse response)  throws Exception {
		
		//세션에 저장되어있는 memberInfo 호출
		HttpSession session=request.getSession();
		session=request.getSession();
		
		String viewName=(String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		String login_id=(String)request.getAttribute("login_id");
		//서비스
		
		
		return mav;
	}
}
