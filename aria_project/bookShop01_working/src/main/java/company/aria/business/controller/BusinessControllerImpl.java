package company.aria.business.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import company.aria.business.service.BusinessService;
import company.aria.business.vo.BusinessVO;
import company.aria.common.base.BaseController;
import company.aria.lack.service.LackStoreServiceImpl;
import company.aria.lack.vo.LaStoreVO;

@Controller("businessController")
@RequestMapping(value="/business")
@EnableAsync
public class BusinessControllerImpl extends BaseController implements BusinessController {
	@Autowired
	private BusinessService businessService;
	@Autowired
	private LackStoreServiceImpl laStoreService;
	
	private BusinessVO businessVO;
	private LaStoreVO lastoreVO;
	
	
	@Override
	@RequestMapping(value="/login.do" ,method = RequestMethod.POST)
	public ModelAndView login(@RequestParam Map<String, String> loginMap,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		businessVO=businessService.login(loginMap);
		String login_id = businessVO.getBu_id();
		lastoreVO=laStoreService.storename(login_id);
		String storename=lastoreVO.getLs_storeName();
		if(businessVO!= null && businessVO.getBu_id()!=null){
			HttpSession session=request.getSession();
			session=request.getSession();
			
			session.setAttribute("login_id", login_id);
			session.setAttribute("storename", storename);
			session.setAttribute("isLogOn", true);
			session.setAttribute("businessInfo",businessVO);
			
			mav.setViewName("redirect:/main/main.do");	
			
		}else{
			mav.setViewName("/member/login");
		}
		return mav;
	}
	@Override
	@RequestMapping(value="/logout.do" ,method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession();
		session.setAttribute("isLogOn", false);
		session.removeAttribute("businessInfo");
		mav.setViewName("redirect:/main/main.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/addMember.do" ,method = RequestMethod.POST)
	public ResponseEntity addMember(@ModelAttribute("businessVO") BusinessVO _businessVO,
			                HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
		    businessService.addMember(_businessVO);
		    message  = "<script>";
		    message +=" alert('회원가입이 완료되었습니다.');";
		    message += " location.href='"+request.getContextPath()+"/business/login.do';";
		    message += " </script>";
		    
		}catch(Exception e) {
			message  = "<script>";
			message +=" alert(ּ'작업에 실패했습니다. 다시 시도해주세요.');";
		    message += " location.href='"+request.getContextPath()+"/business/businessForm.do';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
	
	//�ߺ�üũ ����
	@Override
	@RequestMapping(value="/overlapped.do" ,method = RequestMethod.POST)
	public ResponseEntity overlapped(@RequestParam("bu_id") String id,HttpServletRequest request, HttpServletResponse response) throws Exception{
		ResponseEntity resEntity = null;
		String result = businessService.overlapped(id);
		resEntity =new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}
	
	@Override
	@RequestMapping(value="/overlapped2.do" ,method = RequestMethod.POST)
	public ResponseEntity overlapped2(@RequestParam("bu_email1") String email,HttpServletRequest request, HttpServletResponse response) throws Exception{
		ResponseEntity resEntity = null;
		String result = businessService.overlapped2(email);
		resEntity =new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}
	@Override
	@RequestMapping(value="/pw_auth.do")
	public ModelAndView pwfind(HttpSession session,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception{
			 String email = (String)request.getParameter("bu_email");
			 String id = (String)request.getParameter("id");
			 BusinessVO vo = businessService.pwfind(email);
			 if(vo != null) {
				 Random r = new Random();
				 int num = r.nextInt(999999);
				 System.out.println(num);
				 
				 if(vo.getBu_id().equals(id)) {
					 session.setAttribute("email", vo.getBu_email());
					 
					 String setform = "dlatkd165@naver.com";
					 String tomail = vo.getBu_email();
					 String title = "[아리아]비밀번호 변경 인증 이메일 입니다";
					 String content = System.getProperty("line.separator") + "안녕하세요 회원님" + System.getProperty("line.separator")
						+ "아리아 비밀번호찾기(변경) 인증번호는" + num + "입니다." + System.getProperty("line.separator");
					 
					 try {
							/*
							  MimeMessage message = mailSender.createMimeMessage(); MimeMessageHelper
							  messageHelper = new MimeMessageHelper(message,true,"utf-8");
							  
							  messageHelper.setFrom(setform); messageHelper.setTo(tomail);
							  messageHelper.setSubject(title); messageHelper.setText(content);
							  
							  mailSender.send(message);
							 */
						 businessService.sendMail(tomail, title, content);
					 }catch (Exception e) {
						 System.out.println(e.getMessage());
					 }
					 ModelAndView mav = new ModelAndView();
					 mav.setViewName("/business/pw_auth");
					 mav.addObject("num",num);
					 mav.addObject("email",email);
					 return mav;
				 }else {
					 ModelAndView mav = new ModelAndView();
					 mav.setViewName("/business/pw_find");
					 return mav;
				 }
			 }else {
				 ModelAndView mav = new ModelAndView();
				 mav.setViewName("/business/pw_find");
				 return mav;
			 }
	}
	
	@Override
	@RequestMapping(value = "/pw_set.do", method = RequestMethod.POST)
	public ModelAndView pw_set(@RequestParam(value="email_injeung") String email_injeung,
				@RequestParam(value = "num") String num,@RequestParam(value = "email") String email,HttpServletRequest request, HttpServletResponse response) throws Exception{
			
			if(email_injeung.equals(num)) {
				ModelAndView mav = new ModelAndView();
				mav.addObject(email);
				mav.setViewName("/business/pw_new");
				return mav;
			}
			else {
				ModelAndView mav = new ModelAndView();
				mav.setViewName("/business/pw_find");
				return mav;
			}
	}
	
	@Override
	@RequestMapping(value = "/pw_new.do", method = RequestMethod.POST)
	public ModelAndView pw_new(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		String bu_email =(String)request.getParameter("bu_email");
		String bu_pw =(String)request.getParameter("bu_pw");
		HashMap map = new HashMap();
		map.put("bu_email", bu_email);
		map.put("bu_pw", bu_pw);
		int result = 0;
		result = businessService.modpwd(map);
		ModelAndView mav = new ModelAndView("redirect:/main/main.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/findid.do" ,method = RequestMethod.POST)
	public ModelAndView findid(@RequestParam Map<String, String> findMap,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		 businessVO=businessService.findid(findMap);
		if(businessVO!= null && businessVO.getBu_email()!=null){
			HttpSession session=request.getSession();
			session=request.getSession();
						
			session.setAttribute("businessInfo",businessVO);
			mav.addObject("bu_id",businessVO.getBu_id());
			System.out.println(businessVO.getBu_id());
			
			String action=(String)session.getAttribute("action");
			if(action!=null && action.equals("/order/orderEachGoods.do")){
				mav.setViewName("forward:"+action);
			}else{
				mav.setViewName("/business/resultid");	
			}
			
			
			
		}else{
			String message="찾으시는 아이디가 존재하지 않습니다.";
			mav.addObject("bu_id", message);
			mav.setViewName("forward:/business/resultid.do");
		}
		return mav;
	}
	
}
