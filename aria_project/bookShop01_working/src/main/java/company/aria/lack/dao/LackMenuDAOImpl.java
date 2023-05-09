package company.aria.lack.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;


import company.aria.lack.vo.LaMenuVO;


@Repository("lackmenuDAO")
public class LackMenuDAOImpl {
	@Autowired
	private SqlSession sqlSession;
	
	public int insertNewMenu(Map<String, Object> articleMap) throws DataAccessException {
		int lm_id = selectNewlm_id();	//board_id 는 게시판 번호 순서 숫자임 밑에 저걸 갖고오는게있음
		articleMap.put("lm_id", lm_id);
		sqlSession.insert("mapper.lackmenu.insertNewMenu",articleMap);
		return lm_id;
	}
	
	private int selectNewlm_id() throws DataAccessException {
		return sqlSession.selectOne("mapper.lackmenu.selectNewlm_id");
	}
	
	public List<LaMenuVO> selectGoodsList(String lm_ls_storeName ) throws DataAccessException {
		List<LaMenuVO> goodsList=sqlSession.selectList("mapper.lackmenu.selectGoodsList",lm_ls_storeName);
	   return goodsList;	
     
	}
	
	public LaMenuVO selectGoodsDetail(String lm_id) throws DataAccessException{
		LaMenuVO lamenuVO=(LaMenuVO)sqlSession.selectOne("mapper.lackmenu.selectGoodsDetail",lm_id);
		return lamenuVO;
	}
}
