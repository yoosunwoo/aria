package company.aria.inquiry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import company.aria.inquiry.dao.InquiryDAO;
import company.aria.inquiry.vo.InquiryVO;

@Service("inquiryService")
@Transactional(propagation=Propagation.REQUIRED)
public class InquiryService {
	
	@Autowired
	InquiryDAO inquiryDAO;
	
	@Autowired
	InquiryVO inquiryVO;
	
	public void addinquiry(InquiryVO inquiryVO) throws DataAccessException{
		
	}
	
}
