package company.aria.common_api.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import company.aria.common_api.vo.Common_api_VO;

public interface Common_api_DAO {
	
	public List<Common_api_VO> selectLackStoreList()throws DataAccessException;
	public int insertNewLackStore(Common_api_VO common_api_vo)throws DataAccessException;
	public void searchAllStore(List<Common_api_VO> searchList)throws DataAccessException;

}
