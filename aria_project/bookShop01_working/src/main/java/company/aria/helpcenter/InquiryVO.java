package company.aria.helpcenter;

import java.util.Date;

public class InquiryVO {
	private String mi_in_articleNO;
	private int mi_id;
	private int mi_num;
	private Date mi_creDate;
	private String mi_title;
	private String mi_content;
	
	
	public String getMi_in_articleNO() {
		return mi_in_articleNO;
	}
	public void setMi_in_articleNO(String mi_in_articleNO) {
		this.mi_in_articleNO = mi_in_articleNO;
	}
	public int getMi_id() {
		return mi_id;
	}
	public void setMi_id(int mi_id) {
		this.mi_id = mi_id;
	}
	public int getMi_num() {
		return mi_num;
	}
	public void setMi_num(int mi_num) {
		this.mi_num = mi_num;
	}
	public Date getMi_creDate() {
		return mi_creDate;
	}
	public void setMi_creDate(Date mi_creDate) {
		this.mi_creDate = mi_creDate;
	}
	public String getMi_title() {
		return mi_title;
	}
	public void setMi_title(String mi_title) {
		this.mi_title = mi_title;
	}
	public String getMi_content() {
		return mi_content;
	}
	public void setMi_content(String mi_content) {
		this.mi_content = mi_content;
	}
	
	
}
