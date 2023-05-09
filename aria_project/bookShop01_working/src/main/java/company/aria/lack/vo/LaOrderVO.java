package company.aria.lack.vo;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("LaOrderVO")
public class LaOrderVO {
	private int lo_id;
	private String lo_me_id;
	private String lo_ls_storeName;
	private int lo_lm_id;
	private int lo_qty;
	private String lo_lm_menu;
	private int lo_lm_price;
	private Date lo_creDate;
	private String lo_state;
	private String lo_note;
	private String lo_date;
	private String lo_time;
	
	
//	List로 Cart에 정보를 OrderVO에 담는다
	private List<LaOrderVO> LaOrderVOList;
	
	public List<LaOrderVO> getLaOrderVOList(){
		return LaOrderVOList;
	}
	public void setLaOrderVOList(List<LaOrderVO> LaOrderVOList) {
		this.LaOrderVOList = LaOrderVOList;
	}
	
	public String getLo_ls_storeName() {
		return lo_ls_storeName;
	}
	public void setLo_ls_storeName(String lo_ls_storeName) {
		this.lo_ls_storeName = lo_ls_storeName;
	}
	public String getLo_date() {
		return lo_date;
	}
	public void setLo_date(String lo_date) {
		this.lo_date = lo_date;
	}
	public String getLo_time() {
		return lo_time;
	}
	public void setLo_time(String lo_time) {
		this.lo_time = lo_time;
	}
	public int getLo_id() {
		return lo_id;
	}
	public void setLo_id(int lo_id) {
		this.lo_id = lo_id;
	}
	public String getLo_me_id() {
		return lo_me_id;
	}
	public void setLo_me_id(String lo_me_id) {
		this.lo_me_id = lo_me_id;
	}
	public int getLo_lm_id() {
		return lo_lm_id;
	}
	public void setLo_lm_id(int lo_lm_id) {
		this.lo_lm_id = lo_lm_id;
	}
	public int getLo_qty() {
		return lo_qty;
	}
	public void setLo_qty(int lo_qty) {
		this.lo_qty = lo_qty;
	}
	public String getLo_lm_menu() {
		return lo_lm_menu;
	}
	public void setLo_lm_menu(String lo_lm_menu) {
		this.lo_lm_menu = lo_lm_menu;
	}
	public int getLo_lm_price() {
		return lo_lm_price;
	}
	public void setLo_lm_price(int lo_lm_price) {
		this.lo_lm_price = lo_lm_price;
	}
	public Date getLo_creDate() {
		return lo_creDate;
	}
	public void setLo_creDate(Date lo_creDate) {
		this.lo_creDate = lo_creDate;
	}
	public String getLo_state() {
		return lo_state;
	}
	public void setLo_state(String lo_state) {
		this.lo_state = lo_state;
	}
	public String getLo_note() {
		return lo_note;
	}
	public void setLo_note(String lo_note) {
		this.lo_note = lo_note;
	}
	
	
}
