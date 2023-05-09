package company.aria.member.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import company.aria.member.vo.MemberVO;

public interface MemberService {
	public MemberVO login(Map  loginMap) throws Exception;
	public MemberVO pwfind(String  email) throws Exception;
	public int modpwd(HashMap map) throws Exception;
	public void addMember(MemberVO memberVO) throws Exception;
	public String overlapped(String id) throws Exception;
	public String overlapped2(String email) throws Exception;
	public void sendMail(String to, String subject, String body) throws Exception;
	public MemberVO findid(Map  findMap) throws DataAccessException;
	
	//YSH
	public HashMap confirmMember(HashMap properties)throws Exception;
	public int addMemberByKakao(MemberVO memberVO, HashMap properties)throws Exception;
	public int updateMemberByKakao(MemberVO memberVO, HashMap properties)throws Exception;
}
