package company.aria.lack.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import com.google.gson.Gson;

import company.aria.common.base.BaseController;
import company.aria.common_api.vo.Common_api_VO;
import company.aria.lack.service.LackServiceImpl;
import company.aria.lack.vo.LaMenuVO;
import company.aria.lack.vo.LaStoreVO;
import company.aria.test.TestPageService;

@Controller("lackController")
@RequestMapping(value="/lack")
@EnableAsync
public class LackControllerImpl extends BaseController {
	private static final String ARTICLE_IMAGE_REPO = "C:\\board\\article_image";
	@Autowired						// ARTICLE_IMAGE_REPO 여기에 이미지 저장위치가 담겨있음
	private LackServiceImpl lackService;
	@Autowired
	private LaMenuVO menuVO;
	@Autowired
	protected TestPageService testpageservice;
	
	@RequestMapping(value= "/la-main.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session;
		ModelAndView mav=new ModelAndView();
		String viewName=(String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		
		/*
		 * session=request.getSession(); session.setAttribute("side_menu", "user");
		 * Map<String,List<GoodsVO>> goodsMap=goodsService.listGoods();
		 * mav.addObject("goodsMap", goodsMap);
		 */
		return mav;
	}
	@RequestMapping(value= "/la-store.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView getStoreList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String viewName=(String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		List<LaStoreVO> storeList = new ArrayList();
		storeList = lackService.getStoreList();
		
		List<Common_api_VO> common_api_list = new ArrayList();
		common_api_list = testpageservice.getStoreList();
		
		//transform to json
		Gson gson = new Gson();
		String common_api_list_json = gson.toJson(common_api_list);
		mav.addObject("common_api_list_json", common_api_list_json);
		
		String storeList_json = gson.toJson(storeList);
		mav.addObject("storeList", storeList);
		mav.addObject("storeList_json", storeList_json);
		
		/*
		 * session=request.getSession(); session.setAttribute("side_menu", "user");
		 * Map<String,List<GoodsVO>> goodsMap=goodsService.listGoods();
		 * mav.addObject("goodsMap", goodsMap);
		 */
		return mav;
	}
	
	@RequestMapping(value= "/la-detail.do" ,method={RequestMethod.POST,RequestMethod.GET})
	   public ModelAndView main2(@RequestParam("lm_ls_storeName") String lm_ls_storeName, HttpServletRequest request, HttpServletResponse response) throws Exception{
	      HttpSession session = request.getSession();
	      session.setAttribute("lm_ls_storeName", lm_ls_storeName);
	      ModelAndView mav=new ModelAndView();
	      String viewName=(String)request.getAttribute("viewName");
	      mav.setViewName(viewName);
	      Map<String,List<LaMenuVO>> goodsMap2=lackService.listGoods2(lm_ls_storeName);
	      mav.addObject("goodsMap2", goodsMap2);
	      return mav;
	   }
	
//	@Override				//게시판 글 추가 하는 .do 실행 한개 이미지 글쓰기
	
}
