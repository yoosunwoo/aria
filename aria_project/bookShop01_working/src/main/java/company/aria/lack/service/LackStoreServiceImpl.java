package company.aria.lack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import company.aria.lack.dao.LackStoreDAOImpl;
import company.aria.lack.vo.LaStoreVO;

@Service("lackStoreService")
@Transactional(propagation=Propagation.REQUIRED)
public class LackStoreServiceImpl {
	@Autowired
	private LackStoreDAOImpl lackStoreDAO;

	
	public LaStoreVO storename(String login_id) throws Exception{
		return lackStoreDAO.storename(login_id);
	}
}
