package company.aria.lack.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import company.aria.lack.vo.LaMenuVO;
import company.aria.lack.vo.LaStoreVO;


@Repository("lackDAO")
public class LackDAOImpl implements LackDAO{
	@Autowired
	private SqlSession sqlSession;
	
	public List<LaStoreVO> getStoreList()throws DataAccessException{
		List<LaStoreVO> storeList = sqlSession.selectList("mapper.lackstore.getStoreList");
		return storeList;
	}
	
	public List<LaMenuVO> selectGoodsList2(String lm_ls_storeName ) throws DataAccessException {
	      List<LaMenuVO> goodsList2=sqlSession.selectList("mapper.lackmenu.selectGoodsList2",lm_ls_storeName);
	      return goodsList2;   
	     
	   }
}
