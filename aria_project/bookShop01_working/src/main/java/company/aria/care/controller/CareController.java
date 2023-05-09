package company.aria.care.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface CareController {
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
