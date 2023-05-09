package company.aria.member.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import company.aria.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl  implements MemberDAO{
	@Autowired
	private SqlSession sqlSession;	
	
	@Override
	public MemberVO login(Map loginMap) throws DataAccessException{
		MemberVO member=(MemberVO)sqlSession.selectOne("mapper.member.login",loginMap);
	   return member;
	}
	
	@Override
	public void insertNewMember(MemberVO memberVO) throws DataAccessException{
		sqlSession.insert("mapper.member.insertNewMember",memberVO);
	}

	@Override
	public String selectOverlappedID(String id) throws DataAccessException {
		String result =  sqlSession.selectOne("mapper.member.selectOverlappedID",id);
		return result;
	}
	
	@Override
	public String selectOverlappedEmail(String email) throws DataAccessException {
		String result =  sqlSession.selectOne("mapper.member.selectOverlappedEmail",email);
		System.out.println(result);
		return result;
	}
	
	@Override
	public MemberVO pwfind(String email) throws DataAccessException{
		MemberVO member=(MemberVO)sqlSession.selectOne("mapper.member.pwfind",email);
	   return member;
	}
	
	@Override
	public int updatenewpwd(HashMap map)throws DataAccessException{
		int result=sqlSession.update("mapper.member.updatenewpwd",map);
		 return result;
		}
	
	@Override
	public MemberVO findid(Map findMap) throws DataAccessException {
		MemberVO member=(MemberVO)sqlSession.selectOne("mapper.member.findid",findMap);
		   return member;
	}
	//YSH
	@Override
	public MemberVO confirmMember(HashMap properties)throws DataAccessException{
		MemberVO memberVO = (MemberVO) sqlSession.selectOne("mapper.member.confirmKakaoConnect", properties);
		if(memberVO == null) {
			memberVO = (MemberVO)sqlSession.selectOne("mapper.member.confirmMember", properties);
		}
		return memberVO;
	}
	@Override
	public int insertMemberByKakao(MemberVO memberVO) throws DataAccessException{
		return sqlSession.insert("mapper.member.insertMemberByKakao",memberVO);
	}
	@Override
	public int updateMemberByKakao(MemberVO memberVO) throws DataAccessException{
		return sqlSession.update("mapper.member.updateMemberByKakao", memberVO);
	}
	
}
