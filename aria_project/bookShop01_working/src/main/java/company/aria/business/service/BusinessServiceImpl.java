package company.aria.business.service;

import java.util.HashMap;
import java.util.Map;

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

import company.aria.business.dao.BusinessDAO;
import company.aria.business.vo.BusinessVO;

@Service("businessService")
@Transactional(propagation=Propagation.REQUIRED)
public class BusinessServiceImpl implements BusinessService {
	@Autowired
	private BusinessDAO businessDAO;
	
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
	public BusinessVO login(Map  loginMap) throws Exception{
		return businessDAO.login(loginMap);
	}
	
	@Override
	public void addMember(BusinessVO businessVO) throws Exception{
		businessDAO.insertNewMember(businessVO);
	}
	
	@Override
	public String overlapped(String id) throws Exception{
		return businessDAO.selectOverlappedID(id);
	}
	
	@Override
	public String overlapped2(String email) throws Exception{
		return businessDAO.selectOverlappedEmail(email);
	}
	
	@Override
	public BusinessVO pwfind(String email) throws Exception{
		return businessDAO.pwfind(email);
	}
	
	@Override
	public int modpwd(HashMap map) throws Exception{
		return businessDAO.updatenewpwd(map);
		
	}
	
	@Override
	public BusinessVO findid(Map findMap) throws DataAccessException {
		return businessDAO.findid(findMap);
	}
	
}
