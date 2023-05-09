package company.aria.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import company.aria.common_api.vo.Common_api_VO;

@Repository("TestPageDAO")
public class TestPageDAO {
	@Autowired
	private SqlSession sqlsession;
	
	public List<Common_api_VO> getStoreList()throws DataAccessException{
		List<Common_api_VO> common_api_list = sqlsession.selectList("mapper.test.getStoreList");		
		return common_api_list;
	}

}
