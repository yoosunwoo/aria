package company.aria.lack.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import company.aria.common.base.BaseController;
import company.aria.lack.service.LackCartServiceImpl;
import company.aria.lack.vo.LaCartVO;

@Controller("lackcartController")
@RequestMapping(value="/lackcart")
@EnableAsync
public class LackCartControllerImpl extends BaseController {
	@Autowired
	LaCartVO lacartVO;
	
	@Autowired
	LackCartServiceImpl lackcartService;
	
	
	@RequestMapping(value="/addCart.do" ,method = RequestMethod.POST)
	public ModelAndView addCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int lm_id = Integer.parseInt(request.getParameter("lm_id"));
		int lc_qty = Integer.parseInt(request.getParameter("lc_qty"));
		HttpSession session=request.getSession();
		String login_id=(String)session.getAttribute("login_id");
		HashMap map = new HashMap();
		map.put("lm_id", lm_id);
		map.put("lc_qty", lc_qty);
		map.put("login_id", login_id);
		int result = 0;
		result = lackcartService.addcart(map);
		String lm_ls_storeName = (String)session.getAttribute("lm_ls_storeName");
		ModelAndView mav = new ModelAndView("forward:/lackmenu/la-menu.do?lm_ls_storeName="+lm_ls_storeName);
		return mav;
	}
	
	@RequestMapping(value="/la-cart.do" ,method = RequestMethod.GET)
	public ModelAndView laCart(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName=(String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		HttpSession session=request.getSession();
		String login_id=(String)session.getAttribute("login_id");
		List cartlist=lackcartService.cartlist(login_id);
		mav.addObject("cartlist", cartlist);
		return mav;
	}
	
	@RequestMapping(value="/removeCartGoods.do" ,method = RequestMethod.GET)
	public ModelAndView removeCartGoods(@RequestParam("lm_id") int lm_id,
			                          HttpServletRequest request, HttpServletResponse response)  throws Exception{
		ModelAndView mav=new ModelAndView();
		lackcartService.removeCartGoods(lm_id);
		mav.setViewName("redirect:/lackcart/la-cart.do");
		return mav;
	}
	
}
