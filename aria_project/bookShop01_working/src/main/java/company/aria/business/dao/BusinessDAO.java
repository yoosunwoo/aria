package company.aria.business.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import company.aria.business.vo.BusinessVO;


public interface BusinessDAO {
	public BusinessVO login(Map loginMap) throws DataAccessException;
	public BusinessVO pwfind(String email) throws DataAccessException;
	public void insertNewMember(BusinessVO businessVO) throws DataAccessException;
	public int updatenewpwd(HashMap map) throws DataAccessException;
	public String selectOverlappedID(String id) throws DataAccessException;
	public String selectOverlappedEmail(String email) throws DataAccessException;
	public BusinessVO findid(Map findMap) throws DataAccessException;
}
