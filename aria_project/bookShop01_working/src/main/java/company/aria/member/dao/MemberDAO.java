package company.aria.member.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import company.aria.member.vo.MemberVO;

public interface MemberDAO {
	public MemberVO login(Map loginMap) throws DataAccessException;
	public MemberVO pwfind(String email) throws DataAccessException;
	public void insertNewMember(MemberVO memberVO) throws DataAccessException;
	public int updatenewpwd(HashMap map) throws DataAccessException;
	public String selectOverlappedID(String id) throws DataAccessException;
	public String selectOverlappedEmail(String email) throws DataAccessException;
	public MemberVO findid(Map findMap) throws DataAccessException;
	
	//YSH
	public MemberVO confirmMember(HashMap properties)throws DataAccessException;
	public int insertMemberByKakao(MemberVO memberVO) throws DataAccessException;
	public int updateMemberByKakao(MemberVO memberVO) throws DataAccessException;
}
