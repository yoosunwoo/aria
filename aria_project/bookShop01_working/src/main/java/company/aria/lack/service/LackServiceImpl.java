package company.aria.lack.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import company.aria.lack.dao.LackDAOImpl;
import company.aria.lack.vo.LaMenuVO;
import company.aria.lack.vo.LaStoreVO;

@Service("lackService")
@Transactional(propagation=Propagation.REQUIRED)
public class LackServiceImpl implements LackService {
	@Autowired
	protected LackDAOImpl lackDAO;
	
	public List<LaStoreVO> getStoreList()throws Exception{
		return lackDAO.getStoreList();
	}
	
	public Map<String,List<LaMenuVO>> listGoods2(String lm_ls_storeName) throws Exception {
	      Map<String,List<LaMenuVO>> goodsMap2=new HashMap<String,List<LaMenuVO>>();
	      List<LaMenuVO> goodsList2=lackDAO.selectGoodsList2(lm_ls_storeName);
	      goodsMap2.put("lm_ls_storeName",goodsList2);
	      return goodsMap2;
	   }
	
}
