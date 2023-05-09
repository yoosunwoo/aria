package company.aria.bupage.dao;

import org.springframework.dao.DataAccessException;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import company.aria.business.vo.BusinessVO;

@Repository("bupageDAO")
public class BupageDAO{
	@Autowired
	private SqlSession sqlSession;
	
	public int addStore(String mrhstNm,String bu_id)throws DataAccessException{
		HashMap<String,String> paramMap = new HashMap();
		paramMap.put("bu_id", bu_id);
		paramMap.put("mrhstNm", mrhstNm);
		int result = sqlSession.insert("mapper.bupage.addStore",paramMap);
		return result;
	}
	public int addStore(String bu_id)throws DataAccessException{
		HashMap<String,String> paramMap = new HashMap();
		paramMap.put("bu_id", bu_id);
		int result = sqlSession.insert("mapper.bupage.addAllStore",paramMap);
		return result;
	}
	
//	public List<OrderVO> selectMyOrderGoodsList(String member_id) throws DataAccessException{
//		List<OrderVO> orderGoodsList=(List)sqlSession.selectList("mapper.mypage.selectMyOrderGoodsList",member_id);
//		return orderGoodsList;
//	}
//	
//	public List selectMyOrderInfo(String order_id) throws DataAccessException{
//		List myOrderList=(List)sqlSession.selectList("mapper.mypage.selectMyOrderInfo",order_id);
//		return myOrderList;
//	}	
//
//	public List<OrderVO> selectMyOrderHistoryList(Map dateMap) throws DataAccessException{
//		List<OrderVO> myOrderHistList=(List)sqlSession.selectList("mapper.mypage.selectMyOrderHistoryList",dateMap);
//		return myOrderHistList;
//	}
//	
//	public void updateMyInfo(Map memberMap) throws DataAccessException{
//		sqlSession.update("mapper.mypage.updateMyInfo",memberMap);
//	}
//	
//	public MemberVO selectMyDetailInfo(String member_id) throws DataAccessException{
//		MemberVO memberVO=(MemberVO)sqlSession.selectOne("mapper.mypage.selectMyDetailInfo",member_id);
//		return memberVO;
//		
//	}
//	
//	public void updateMyOrderCancel(String order_id) throws DataAccessException{
//		sqlSession.update("mapper.mypage.updateMyOrderCancel",order_id);
//	}
//	
//	public int deleteMember(String login_id) throws DataAccessException{
//		int result = sqlSession.delete("mapper.mypage.deleteMember",login_id);
//		return result;
//	}
	
	public void updateMember(BusinessVO businessVO) throws DataAccessException{
		sqlSession.update("mapper.bupage.updateMember",businessVO);
	}
	
	public int deleteMember(String login_id) throws DataAccessException{
	      int result = sqlSession.delete("mapper.bupage.deleteMember",login_id);
	      return result;
	   }
	
}
