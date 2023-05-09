package company.aria.inquiry.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("inquiryVO")
public class InquiryVO {
	private String mi_me_id;
	private String mi_ls_storeName;
	private int mi_num;
	private int mi_depth;
	private int mi_title;
	private int mi_content;
	private Date mi_creDate;
	
	
	
	public String getMi_ls_storeName() {
		return mi_ls_storeName;
	}
	public void setMi_ls_storeName(String mi_ls_storeName) {
		this.mi_ls_storeName = mi_ls_storeName;
	}
	public int getMi_depth() {
		return mi_depth;
	}
	public void setMi_depth(int mi_depth) {
		this.mi_depth = mi_depth;
	}
	public int getMi_title() {
		return mi_title;
	}
	public void setMi_title(int mi_title) {
		this.mi_title = mi_title;
	}
	public int getMi_content() {
		return mi_content;
	}
	public void setMi_content(int mi_content) {
		this.mi_content = mi_content;
	}
	public String getMi_me_id() {
		return mi_me_id;
	}
	public void setMi_me_id(String mi_me_id) {
		this.mi_me_id = mi_me_id;
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
	
}
