package company.aria.lack.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("lacartVO")
public class LaCartVO {
	private int lc_id;
	private String lc_me_id;
	private int lc_is_storeNo;
	private int lc_lm_id;
	private int lc_qty;
	private Date lc_creDate;
	
	
	public int getLc_id() {
		return lc_id;
	}
	public void setLc_id(int lc_id) {
		this.lc_id = lc_id;
	}
	public String getLc_me_id() {
		return lc_me_id;
	}
	public void setLc_me_id(String lc_me_id) {
		this.lc_me_id = lc_me_id;
	}
	public int getLc_is_storeNo() {
		return lc_is_storeNo;
	}
	public void setLc_is_storeNo(int lc_is_storeNo) {
		this.lc_is_storeNo = lc_is_storeNo;
	}
	public int getLc_lm_id() {
		return lc_lm_id;
	}
	public void setLc_lm_id(int lc_lm_id) {
		this.lc_lm_id = lc_lm_id;
	}
	public int getLc_qty() {
		return lc_qty;
	}
	public void setLc_qty(int lc_qty) {
		this.lc_qty = lc_qty;
	}
	public Date getLc_creDate() {
		return lc_creDate;
	}
	public void setLc_creDate(Date lc_creDate) {
		this.lc_creDate = lc_creDate;
	}
	
}
