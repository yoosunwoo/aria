package company.aria.business.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import company.aria.business.vo.BusinessVO;

@Repository("businessDAO")
public class BusinessDAOImpl implements BusinessDAO {
	@Autowired
	private SqlSession sqlSession;	
	
	@Override
	public BusinessVO login(Map loginMap) throws DataAccessException{
		BusinessVO member=(BusinessVO)sqlSession.selectOne("mapper.business.login",loginMap);
	   return member;
	}
	
	@Override
	public void insertNewMember(BusinessVO businessVO) throws DataAccessException{
		sqlSession.insert("mapper.business.insertNewMember",businessVO);
	}

	@Override
	public String selectOverlappedID(String id) throws DataAccessException {
		String result =  sqlSession.selectOne("mapper.business.selectOverlappedID",id);
		return result;
	}
	
	@Override
	public String selectOverlappedEmail(String email) throws DataAccessException {
		String result =  sqlSession.selectOne("mapper.member.selectOverlappedEmail",email);
		System.out.println(result);
		return result;
	}
	
	@Override
	public BusinessVO pwfind(String email) throws DataAccessException{
		BusinessVO business=(BusinessVO)sqlSession.selectOne("mapper.business.pwfind",email);
		System.out.println(business.getBu_email()+"DAO------------");
	   return business;
	}
	
	@Override
	public int updatenewpwd(HashMap map)throws DataAccessException{
		int result=sqlSession.update("mapper.business.updatenewpwd",map);
		 return result;
		}
	
	@Override
	public BusinessVO findid(Map findMap) throws DataAccessException {
		BusinessVO member=(BusinessVO)sqlSession.selectOne("mapper.business.findid",findMap);
		   return member;
	}
}
