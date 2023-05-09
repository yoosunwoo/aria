package company.aria.lack.dao;

import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import company.aria.lack.vo.LaOrderVO;




@Repository("lackorderDAO")
public class LackOrderDAOImpl {
	@Autowired
	private SqlSession sqlSession;
	
	public void insertOrder(LaOrderVO laOrderVO) {
		List<LaOrderVO> list = laOrderVO.getLaOrderVOList();
		
		
		Iterator iterator = list.iterator();
		while(iterator.hasNext()) {
			LaOrderVO entry = (LaOrderVO)iterator.next();
			
			sqlSession.insert("mapper.lackorder.insertOrder", entry);
		}
		
	}
}
