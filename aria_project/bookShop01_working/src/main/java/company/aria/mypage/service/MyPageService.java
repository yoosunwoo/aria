package company.aria.mypage.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import company.aria.member.vo.MemberVO;
import company.aria.mypage.dao.MyPageDAO;

@Service("mypageService")
@Transactional(propagation=Propagation.REQUIRED)
public class MyPageService {
	@Autowired
	MyPageDAO mypageDAO;
	
	public void updateMember(MemberVO memberVO) throws Exception{
		mypageDAO.updateMember(memberVO);
	}
	
	public int deletemember(String login_id) throws Exception{
	      return mypageDAO.deleteMember(login_id);
	   }
	
	public int updatecard(HashMap map) throws Exception{
		return mypageDAO.updatecard(map);
		
	}
}
