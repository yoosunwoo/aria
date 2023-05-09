package company.aria.bupage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import company.aria.bupage.dao.BupageDAO;
import company.aria.business.vo.BusinessVO;

@Service("bupageService")
@Transactional(propagation=Propagation.REQUIRED)
public class BupageService {
	@Autowired
	protected BupageDAO bupagedao;
	
	public int addStore(String mrhstNm,String bu_id)throws Exception{
		return bupagedao.addStore(mrhstNm,bu_id);
	}
	public int addStore(String bu_id)throws Exception{
		return bupagedao.addStore(bu_id);
	}
	
	public void updateMember(BusinessVO businessVO) throws Exception{
		bupagedao.updateMember(businessVO);
	}
	
	public int deletemember(String login_id) throws Exception{
	      return bupagedao.deleteMember(login_id);
	   }
}
