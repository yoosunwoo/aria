package company.aria.mypage.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import company.aria.member.vo.MemberVO;

@Repository("mypageDAO")
public class MyPageDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public void updateMember(MemberVO memberVO) throws DataAccessException{
		sqlSession.update("mapper.mypage.updateMember",memberVO);
	}
	
	public int deleteMember(String login_id) throws DataAccessException{
	      int result = sqlSession.delete("mapper.mypage.deleteMember",login_id);
	      return result;
	   }
	
	public int updatecard(HashMap map)throws DataAccessException{
		int result=sqlSession.update("mapper.mypage.updatecard",map);
		 return result;
		}
}
