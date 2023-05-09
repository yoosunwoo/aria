package company.aria.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import company.aria.common_api.vo.Common_api_VO;

@RestController
@RequestMapping(value="/test")
@Controller("TestPageController")
public class TestPageController {
	@Autowired
	private TestPageService testpageservice;
	@Autowired
	private Common_api_VO common_api_vo;
	
/*
	@ResponseBody
	@RequestMapping(value="/testPage.do", method=RequestMethod.GET)
	public ResponseEntity testMain(HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		ResponseEntity resEntity = null;
		String message = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8;");
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
*/
	@ResponseBody
	@RequestMapping(value="/*.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView testMain(HttpServletRequest request, HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView();
		String viewName = (String)request.getAttribute("viewName");
		
		if(viewName.equals("/test/testPage2")) {
			List<Common_api_VO> common_api_list = new ArrayList();
			common_api_list = testpageservice.getStoreList();
			
			//transform to json
			Gson gson = new Gson();
			String common_api_list_json = gson.toJson(common_api_list);
			
			System.out.println(common_api_list_json);
			
			mav.addObject("common_api_list_json", common_api_list_json);
		}
		if(viewName.equals("/test/testPage4")) {
			List<TestPageVO> fruitList = new ArrayList();
			fruitList = testpageservice.getFruitList();
			mav.addObject("fruitList", fruitList);
		}
		
		mav.setViewName(viewName);
		return mav;
	}
	//@ModelAttribute list(Object) test
	@RequestMapping(value="/testPage5.do", method=RequestMethod.POST)
	public ModelAndView fruit(@ModelAttribute TestPageVO fruitsVOList,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView();
		String viewName = (String)request.getAttribute("viewName");
		
//		List<TestPageVO> fruitList = fruitListArray.asList(new TestPageVO());
//		List<TestPageVO> fruitList = new ArrayList(Arrays.asList(fruitListArray));
		
		Iterator iterator = fruitsVOList.getFruitsVOList().iterator();
		while(iterator.hasNext()) {
			TestPageVO entry = (TestPageVO)iterator.next();
			System.out.println("번호:"+entry.getFruitNo()+" 이름:"+entry.getFruitName()+" 색깔:"+entry.getFruitColor());
		}
		
		mav.setViewName("forward://test/testPage.do");
		return mav;
	}

}
