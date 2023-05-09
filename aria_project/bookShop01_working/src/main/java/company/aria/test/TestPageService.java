package company.aria.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import company.aria.common_api.vo.Common_api_VO;

@Service("TestPageService")
@Transactional(propagation=Propagation.REQUIRED)
public class TestPageService {
	@Autowired
	private TestPageDAO testpagedao;
	@Autowired
	private Common_api_VO common_api_vo;
	@Autowired
	private TestPageVO testpageVO;
	
	public List<Common_api_VO> getStoreList()throws Exception{
		List<Common_api_VO> common_api_list = testpagedao.getStoreList();
		return common_api_list;
	}
	public List<TestPageVO> getFruitList()throws Exception{
		List<TestPageVO> fruitList = new ArrayList();
		TestPageVO fruit1 = new TestPageVO();
		fruit1.setFruitNo(1);
		fruit1.setFruitName("사과");
		fruit1.setFruitColor("red");
		
		TestPageVO fruit2 = new TestPageVO();
		fruit2.setFruitNo(2);
		fruit2.setFruitName("레몬");
		fruit2.setFruitColor("yellow");
		
		TestPageVO fruit3 = new TestPageVO();
		fruit3.setFruitNo(3);
		fruit3.setFruitName("수박");
		fruit3.setFruitColor("green");
		
		TestPageVO fruit4 = new TestPageVO();
		fruit4.setFruitNo(4);
		fruit4.setFruitName("배");
		fruit4.setFruitColor("white");
		
		fruitList.add(fruit1);
		fruitList.add(fruit2);
		fruitList.add(fruit3);
		fruitList.add(fruit4);
		return fruitList;
	}
	

}
