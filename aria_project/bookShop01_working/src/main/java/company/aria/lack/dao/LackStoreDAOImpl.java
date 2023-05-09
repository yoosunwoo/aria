package company.aria.lack.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import company.aria.lack.vo.LaStoreVO;


@Repository("lackStoreDAO")
public class LackStoreDAOImpl {
	@Autowired
	private SqlSession sqlSession;
	
	
	public LaStoreVO storename(String login_id) throws DataAccessException{
		LaStoreVO lastore=(LaStoreVO)sqlSession.selectOne("mapper.lackstore.selectstore",login_id);
	   return lastore;
	}
}
