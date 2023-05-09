package company.aria.lack.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import company.aria.lack.dao.LackCartDAOImpl;
import company.aria.lack.vo.LaCartVO;


@Service("lackcartService")
@Transactional(propagation=Propagation.REQUIRED)
public class LackCartServiceImpl {
	@Autowired
	LackCartDAOImpl lackcartDAO;
	
	@Autowired
	LaCartVO lacartVO;
	
	public int addcart(HashMap map) throws Exception{
		return lackcartDAO.insertCart(map);
	}
	
	public List cartlist(String login_id) throws Exception{
		return lackcartDAO.selectCartlist(login_id);
	}
	
	public void removeCartGoods(int lm_id) throws Exception{
		lackcartDAO.deleteCartGoods(lm_id);
	}
	
	public void deleteAll(String login_id) throws Exception {
		lackcartDAO.deleteAll(login_id);
	}

}
