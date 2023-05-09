package company.aria.lack.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("LaStoreVO")
public class LaStoreVO {
	private int ls_storeNo;
	private String ls_bu_id;
	private String ls_storeName;
	private String ls_phone;
	private String ls_address_road;
	private String ls_address_jibun;
	private String ls_pack_yes;
	private String ls_visit_yes;
	private String ls_review_yes;
	private String ls_disabled;
	private Date ls_creDate;
	private String ls_note;
	
	public int getLs_storeNo() {
		return ls_storeNo;
	}
	public void setLs_storeNo(int ls_storeNo) {
		this.ls_storeNo = ls_storeNo;
	}
	public String getLs_bu_id() {
		return ls_bu_id;
	}
	public void setLs_bu_id(String ls_bu_id) {
		this.ls_bu_id = ls_bu_id;
	}
	public String getLs_storeName() {
		return ls_storeName;
	}
	public void setLs_storeName(String ls_storeName) {
		this.ls_storeName = ls_storeName;
	}
	public String getLs_phone() {
		return ls_phone;
	}
	public void setLs_phone(String ls_phone) {
		this.ls_phone = ls_phone;
	}
	public String getLs_address_road() {
		return ls_address_road;
	}
	public void setLs_address_road(String ls_address_road) {
		this.ls_address_road = ls_address_road;
	}
	public String getLs_address_jibun() {
		return ls_address_jibun;
	}
	public void setLs_address_jibun(String ls_address_jibun) {
		this.ls_address_jibun = ls_address_jibun;
	}
	public String getLs_pack_yes() {
		return ls_pack_yes;
	}
	public void setLs_pack_yes(String ls_pack_yes) {
		this.ls_pack_yes = ls_pack_yes;
	}
	public String getLs_visit_yes() {
		return ls_visit_yes;
	}
	public void setLs_visit_yes(String ls_visit_yes) {
		this.ls_visit_yes = ls_visit_yes;
	}
	public String getLs_review_yes() {
		return ls_review_yes;
	}
	public void setLs_review_yes(String ls_review_yes) {
		this.ls_review_yes = ls_review_yes;
	}
	public String getLs_disabled() {
		return ls_disabled;
	}
	public void setLs_disabled(String ls_disabled) {
		this.ls_disabled = ls_disabled;
	}
	public Date getLs_creDate() {
		return ls_creDate;
	}
	public void setLs_creDate(Date ls_creDate) {
		this.ls_creDate = ls_creDate;
	}
	public String getLs_note() {
		return ls_note;
	}
	public void setLs_note(String ls_note) {
		this.ls_note = ls_note;
	}
	
}
