package company.aria.common_api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface Common_api_Controller {
	
	public ResponseEntity callCommon_api(@RequestParam int pageNum, @RequestParam String searchCtprvnNm, @RequestParam int numOfRows, HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ResponseEntity searchAllStore(@RequestParam String searchCtprvnNm, HttpServletRequest request, HttpServletResponse response)throws Exception;

}
