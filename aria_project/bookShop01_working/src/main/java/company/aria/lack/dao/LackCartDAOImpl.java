package company.aria.lack.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;




@Repository("lackcartDAO")
public class LackCartDAOImpl {
	@Autowired
	private SqlSession sqlSession;
	
	public int insertCart(HashMap map) throws DataAccessException {
		int result = sqlSession.insert("mapper.lackcart.insertCart",map);
		return result;
	}
	
	public List selectCartlist(String login_id) throws DataAccessException {
		List cartMap = sqlSession.selectList("mapper.lackcart.selectCartlist",login_id);
		return cartMap;
	}
	
	public void deleteCartGoods(int lm_id) throws DataAccessException{
		sqlSession.delete("mapper.lackcart.deleteCartGoods",lm_id);
	}
	
	public void deleteAll(String login_id) throws DataAccessException{
		sqlSession.delete("mapper.lackcart.deleteAll", login_id);
	}
}
