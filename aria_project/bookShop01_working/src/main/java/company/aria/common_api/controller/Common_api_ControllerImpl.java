package company.aria.common_api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import company.aria.common_api.service.Common_api_Service;
import company.aria.common_api.vo.Common_api_VO;

@RestController
@Controller("Common_api_Controller")
public class Common_api_ControllerImpl implements Common_api_Controller {
	@Autowired
	private Common_api_Service common_api_service;
	@Autowired
	private Common_api_VO common_api_vo;
	
	@Override
	@ResponseBody
	@RequestMapping(value="/callCommon_api.do",method=RequestMethod.POST)
	public ResponseEntity callCommon_api(@RequestParam int pageNum, @RequestParam String searchCtprvnNm, @RequestParam int numOfRows, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		String message = null;
		responseHeaders.add("Content-Type", "text/html; charset=utf-8;");
		
		List<Common_api_VO> common_api_list = new ArrayList();
		common_api_list = common_api_service.getCommonApi(pageNum,searchCtprvnNm,numOfRows);
		
		//transform to json
		Gson gson = new Gson();
		String common_api_list_json = gson.toJson(common_api_list);
		System.out.println("\t json :"+common_api_list_json);
		
		resEntity =new ResponseEntity(common_api_list_json, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
	@Override
	@ResponseBody
	@RequestMapping(value="/searchAllStore.do",method=RequestMethod.POST)
	public ResponseEntity searchAllStore(@RequestParam String searchCtprvnNm, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8;");
		Integer result = 1;
		
		long start = System.nanoTime();
		
//		common_api_service.searchAllStore(searchCtprvnNm);
//		CompletableFuture<Integer> future = common_api_service.searchAllStore(searchCtprvnNm);
		Future<Integer> future = common_api_service.searchAllStore(searchCtprvnNm);
		result = (Integer) future.get();
		
		long end = System.nanoTime();
		System.out.println("\t searchAllStore time : "+(end-start)+" ns");
		
		resEntity =new ResponseEntity(result, responseHeaders, HttpStatus.OK);
		return resEntity;
	}

}
