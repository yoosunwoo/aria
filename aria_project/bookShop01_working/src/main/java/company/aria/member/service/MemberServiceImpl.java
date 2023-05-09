package company.aria.member.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import company.aria.member.dao.MemberDAO;
import company.aria.member.vo.MemberVO;

@Service("memberService")
@Transactional(propagation=Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private SimpleMailMessage preConfiguredMessage;
	
	@Async  //�̸��Ϻ�����
	@Override
	public void sendMail(String to, String subject, String body) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true,"UTF-8");
			messageHelper.setFrom("dlatkd165@naver.com","아리아");
			messageHelper.setSubject(subject);
			messageHelper.setTo(to);
			messageHelper.setText(body);
			mailSender.send(message);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public MemberVO login(Map  loginMap) throws Exception{
		return memberDAO.login(loginMap);
	}
	
	@Override
	public void addMember(MemberVO memberVO) throws Exception{
		memberDAO.insertNewMember(memberVO);
	}
	
	@Override
	public String overlapped(String id) throws Exception{
		return memberDAO.selectOverlappedID(id);
	}
	
	@Override
	public String overlapped2(String email) throws Exception{
		return memberDAO.selectOverlappedEmail(email);
	}
	
	@Override
	public MemberVO pwfind(String email) throws Exception{
		return memberDAO.pwfind(email);
	}
	
	@Override
	public int modpwd(HashMap map) throws Exception{
		return memberDAO.updatenewpwd(map);
		
	}
	
	@Override
	public MemberVO findid(Map findMap) throws DataAccessException {
		return memberDAO.findid(findMap);
	}
	//YSH
	@Override
	public HashMap confirmMember(HashMap properties)throws Exception{
		HashMap resultMap = new HashMap();
		int resultMsg = 0; // resultMsg [0] : error / [1] : already existed kakao_id / [2] : not existed kakao_id / [3] : is not member
		MemberVO memberVO = memberDAO.confirmMember(properties);
		if(memberVO == null) {
			resultMsg = 3;
			resultMap.put("resultMsg", resultMsg);
			return resultMap;
		}
		String kakao_id = memberVO.getMe_kakao_log_id();
		String me_name = memberVO.getMe_name();
		//System.out.println("\t check result - memberVO [kakao_id / me_name] "+kakao_id+" / "+me_name);
		
		if(me_name !=null && (kakao_id == null||kakao_id.isBlank())){
			resultMsg = 2;
			resultMap.put("resultMsg", resultMsg);
			resultMap.put("memberVO", memberVO);
			return resultMap;
		}else {
			resultMsg = 1;
			resultMap.put("resultMsg", resultMsg);
			resultMap.put("memberVO", memberVO);
		}
		return resultMap;
		/*
		if(!(kakao_id == null || kakao_id.equals(0))) {
			resultMsg = 1;
			resultMap.put("resultMsg", resultMsg);
			return resultMap;
		}else if(!(me_name == null)){
			resultMsg = 2;
			resultMap.put("resultMsg", resultMsg);
			resultMap.put("memberVO", memberVO);
			return resultMap;
		}else {
			resultMsg = 3;
			resultMap.put("resultMsg", resultMsg);
		}
		return resultMap;
		*/
	}
	@Override
	public int addMemberByKakao(MemberVO memberVO, HashMap properties)throws Exception{
		memberVO.setMe_kakao_log_id((String)properties.get("id"));
		memberVO.setMe_kakao_log_conDate((String)properties.get("connected_at"));
		memberVO.setMe_kakao_log_yes("yes");
		if((Boolean)properties.get("has_gender")) memberVO.setMe_gender((String)properties.get("gender"));
		if((Boolean)properties.get("has_age_range")) memberVO.setMe_age_range((String)properties.get("age_range"));
		return memberDAO.insertMemberByKakao(memberVO);
	}
	@Override
	public int updateMemberByKakao(MemberVO memberVO, HashMap properties)throws Exception{
		memberVO.setMe_kakao_log_id((String)properties.get("id"));
		memberVO.setMe_kakao_log_conDate((String)properties.get("connected_at"));
		memberVO.setMe_kakao_log_yes("yes");
		if((Boolean)properties.get("has_gender")) memberVO.setMe_gender((String)properties.get("gender"));
		if((Boolean)properties.get("has_age_range")) memberVO.setMe_age_range((String)properties.get("age_range"));
		return memberDAO.updateMemberByKakao(memberVO);
	}
	
}
