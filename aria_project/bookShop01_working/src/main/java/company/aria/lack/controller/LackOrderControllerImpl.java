package company.aria.lack.controller;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import company.aria.common.base.BaseController;
import company.aria.lack.service.LackCartServiceImpl;
import company.aria.lack.service.LackMenuServiceImpl;
import company.aria.lack.service.LackOrderServiceImpl;
import company.aria.lack.vo.LaOrderVO;

@Controller("lackorderController")
@RequestMapping(value="/lackorder")
@EnableAsync
public class LackOrderControllerImpl extends BaseController {
	@Autowired
	LaOrderVO laorderVO;
	
	@Autowired
	LackOrderServiceImpl lackorderService;
	
	@Autowired
	LackCartServiceImpl lackcartService;
	
	@RequestMapping(value="/addOrder.do", method=RequestMethod.POST)
	public ModelAndView LaOrder(@ModelAttribute LaOrderVO LaOrderVOList,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView();
		String viewName = (String)request.getAttribute("viewName");
		
		Iterator iterator = LaOrderVOList.getLaOrderVOList().iterator();
		while(iterator.hasNext()) {
			LaOrderVO entry = (LaOrderVO)iterator.next();
			System.out.println(entry.getLo_lm_price()+"원"+entry.getLo_lm_id()+"회원"+entry.getLo_lm_menu()+"매뉴명");
		}
		
		HttpSession session=request.getSession();
		String login_id=(String)session.getAttribute("login_id");
		
		//VO를 list로 만들어 배열 형태로 넘겨줌
		lackorderService.addorder(LaOrderVOList);
		//주문 넘어간 CartList를 제거
		lackcartService.deleteAll(login_id);
		
		mav.setViewName("forward://main/main.do");
		return mav;
	}
}
