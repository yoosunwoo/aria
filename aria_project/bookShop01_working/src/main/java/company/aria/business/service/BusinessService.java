package company.aria.business.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import company.aria.business.vo.BusinessVO;

public interface BusinessService {
	public BusinessVO login(Map  loginMap) throws Exception;
	public BusinessVO pwfind(String  email) throws Exception;
	public int modpwd(HashMap map) throws Exception;
	public void addMember(BusinessVO memberVO) throws Exception;
	public String overlapped(String id) throws Exception;
	public String overlapped2(String email) throws Exception;
	public void sendMail(String to, String subject, String body) throws Exception;
	public BusinessVO findid(Map  findMap) throws DataAccessException;
}
