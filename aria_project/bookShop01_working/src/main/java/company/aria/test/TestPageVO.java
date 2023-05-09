package company.aria.test;

import java.util.List;

import org.springframework.stereotype.Component;

@Component("TestPageVO")
public class TestPageVO {
	private int fruitNo;
	private String fruitName;
	private String fruitColor;
	
	//List
	private List<TestPageVO> fruitsVOList;
	
	public List<TestPageVO> getFruitsVOList() {
		return fruitsVOList;
	}
	public void setFruitsVOList(List<TestPageVO> fruitsVOList) {
		this.fruitsVOList = fruitsVOList;
	}
	//
	public int getFruitNo() {
		return fruitNo;
	}
	public void setFruitNo(int fruitNo) {
		this.fruitNo = fruitNo;
	}
	public String getFruitName() {
		return fruitName;
	}
	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}
	public String getFruitColor() {
		return fruitColor;
	}
	public void setFruitColor(String fruitColor) {
		this.fruitColor = fruitColor;
	}
	

}
