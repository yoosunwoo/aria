package company.aria.lack.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import company.aria.lack.dao.LackMenuDAOImpl;
import company.aria.lack.vo.LaMenuVO;


@Service("lackmenuService")
@Transactional(propagation=Propagation.REQUIRED)
public class LackMenuServiceImpl {
	@Autowired
	LackMenuDAOImpl lackmenuDAO;
	
	
	public int addNewMenu(Map articleMap) throws Exception{
		return lackmenuDAO.insertNewMenu(articleMap);
	}
	
	public Map<String,List<LaMenuVO>> listGoods(String lm_ls_storeName) throws Exception {
		Map<String,List<LaMenuVO>> goodsMap=new HashMap<String,List<LaMenuVO>>();
		List<LaMenuVO> goodsList=lackmenuDAO.selectGoodsList(lm_ls_storeName);
		goodsMap.put("lm_ls_storeName",goodsList);
		return goodsMap;
	}
	
	public Map goodsDetail(String lm_id) throws Exception {
		Map goodsMap=new HashMap();
		LaMenuVO lamenuVO = lackmenuDAO.selectGoodsDetail(lm_id);
		goodsMap.put("goodsVO", lamenuVO);
		
		return goodsMap;
	}
}
