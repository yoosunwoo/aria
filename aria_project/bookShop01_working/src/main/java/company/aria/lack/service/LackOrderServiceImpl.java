package company.aria.lack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import company.aria.lack.dao.LackOrderDAOImpl;
import company.aria.lack.vo.LaOrderVO;


@Service("lackorderService")
@Transactional(propagation=Propagation.REQUIRED)
public class LackOrderServiceImpl {
	@Autowired
	LackOrderDAOImpl lackorderDAO;
	
	@Autowired
	LaOrderVO laorderVO;
	
	public void addorder(LaOrderVO laorderVO) throws Exception{
		lackorderDAO.insertOrder(laorderVO);
	}
}
