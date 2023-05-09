package company.aria.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import company.aria.member.vo.MemberVO;

public interface MemberController {
	public ModelAndView login(@RequestParam Map<String, String> loginMap,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity  addMember(@ModelAttribute("member") MemberVO member,
            HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity   overlapped(@RequestParam("id") String id,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity   overlapped2(@RequestParam("email") String id,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView pwfind(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView pw_set(@RequestParam(value="email_injeung") String email_injeung,@RequestParam(value = "email") String email,
			@RequestParam(value = "num") String num,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView pw_new(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView findid(@RequestParam Map<String, String> loginMap,
            HttpServletRequest request, HttpServletResponse response) throws Exception;
}
