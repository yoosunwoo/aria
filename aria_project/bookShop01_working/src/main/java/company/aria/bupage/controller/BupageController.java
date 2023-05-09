package company.aria.bupage.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.google.gson.Gson;

import company.aria.bupage.service.BupageService;
import company.aria.business.vo.BusinessVO;
import company.aria.common.base.BaseController;
import company.aria.common_api.vo.Common_api_VO;
import company.aria.test.TestPageService;

@Controller("bupageController")
@RequestMapping(value="/bupage")
public class BupageController extends BaseController {
	@Autowired
	protected BupageService bupageservice;
	@Autowired
	private BusinessVO businessVO;
	@Autowired
	protected TestPageService testpageservice;
	
	@RequestMapping(value="/bupageMain.do" ,method = RequestMethod.GET)
	public ModelAndView bupageMain(@RequestParam(required = false,value="message")  String message,
			   HttpServletRequest request, HttpServletResponse response)  throws Exception {
		HttpSession session=request.getSession();
		businessVO = (BusinessVO)session.getAttribute("businessInfo");
		String viewName=(String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		mav.setViewName(viewName);
		return mav;
	}
	@RequestMapping(value="/bupageSelectStore.do" ,method = RequestMethod.POST)
	public ModelAndView bupageSelectStore(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		HttpSession session=request.getSession();
		businessVO = (BusinessVO)session.getAttribute("businessInfo");
		String viewName=(String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		List<Common_api_VO> common_api_list = new ArrayList();
		common_api_list = testpageservice.getStoreList();
		
		//transform to json
		Gson gson = new Gson();
		String common_api_list_json = gson.toJson(common_api_list);
		
		//System.out.println(common_api_list_json);
		mav.addObject("common_api_list", common_api_list);
		mav.addObject("common_api_list_json", common_api_list_json);
		
		mav.setViewName(viewName);
		return mav;
	}
	@RequestMapping(value="/addStore.do" ,method = RequestMethod.GET)
	public ModelAndView addStore(@RequestParam String mrhstNm, HttpServletRequest request, HttpServletResponse response)  throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession();
		businessVO = (BusinessVO)session.getAttribute("businessInfo");
		String bu_id = businessVO.getBu_id();
		try{
			int result = bupageservice.addStore(mrhstNm,bu_id);
			if(result == 1) {
				mav.setViewName("redirect:/main/main.do");
			}
		}catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("forward:/bupage/bupageSelectStore.do");
		}
		return mav;
	}
	@RequestMapping(value="/addAllStore.do" ,method = RequestMethod.GET)
	public ModelAndView addStore(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session=request.getSession();
		businessVO = (BusinessVO)session.getAttribute("businessInfo");
		String bu_id = businessVO.getBu_id();
		try{
			int result = bupageservice.addStore(bu_id);
			if(result == 1) {
				mav.setViewName("redirect:/main/main.do");
			}
		}catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("forward:/bupage/bupageSelectStore.do");
		}
		return mav;
	}
//	사업자 정보 수정
	@RequestMapping(value="/modbu.do" ,method = RequestMethod.GET)
	public ModelAndView modbu(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		String viewName=(String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	
	}
	
	@RequestMapping(value="/updateMember.do" ,method = RequestMethod.POST)
	public ResponseEntity updateMember(@ModelAttribute("businessVO") BusinessVO _businessVO,
			                HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			bupageservice.updateMember(_businessVO);
		    message  = "<script>";
		    message +=" alert('사업자정보 수정이 완료되었습니다.');";
		    message += " location.href='"+request.getContextPath()+"/bupage/bupageMain.do';";
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
	      bupageservice.deletemember(login_id);
	      ModelAndView mav = new ModelAndView("redirect:/main/main.do");
	      return mav;
	   }
	
}
