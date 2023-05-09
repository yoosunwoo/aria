package company.aria.common_api.dao;

import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import company.aria.common_api.vo.Common_api_VO;

@Repository("Common_api_DAOImpl")
public class Common_api_DAOImpl implements Common_api_DAO{
	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public List<Common_api_VO> selectLackStoreList()throws DataAccessException{
		List<Common_api_VO> lackStoreList = sqlsession.selectList("mapper.common_api.selectLackStoreList");
		return lackStoreList;
	}
	@Override
	public int insertNewLackStore(Common_api_VO common_api_vo)throws DataAccessException{
		int result = sqlsession.insert("mapper.common_api.insertNewLackStore", common_api_vo);
		return result;
	}
	@Override
	public void searchAllStore(List<Common_api_VO> searchList)throws DataAccessException{
		Iterator<Common_api_VO> iterator = searchList.iterator();
		while(iterator.hasNext()){
			Common_api_VO common_api_vo = iterator.next();
			sqlsession.insert("mapper.common_api.searchAllStore", common_api_vo);
		}
	}

}