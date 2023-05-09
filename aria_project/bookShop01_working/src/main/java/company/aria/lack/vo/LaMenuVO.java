package company.aria.lack.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("lamenuVO")
public class LaMenuVO {
	private int lm_id;
	private String lm_menu;
	private String lm_menu_info;
	private int lm_price;
	private Date lm_creDate;
	private String lm_fileName;
	private String lm_ls_storeName;
	

	public String getLm_ls_storeName() {
		return lm_ls_storeName;
	}
	public void setLm_ls_storeName(String lm_ls_storeName) {
		this.lm_ls_storeName = lm_ls_storeName;
	}
	public int getLm_id() {
		return lm_id;
	}
	public void setLm_id(int lm_id) {
		this.lm_id = lm_id;
	}
	public String getLm_menu() {
		return lm_menu;
	}
	public void setLm_menu(String lm_menu) {
		this.lm_menu = lm_menu;
	}
	public String getLm_menu_info() {
		return lm_menu_info;
	}
	public void setLm_menu_info(String lm_menu_info) {
		this.lm_menu_info = lm_menu_info;
	}
	public int getLm_price() {
		return lm_price;
	}
	public void setLm_price(int lm_price) {
		this.lm_price = lm_price;
	}
	public Date getLm_creDate() {
		return lm_creDate;
	}
	public void setLm_creDate(Date lm_creDate) {
		this.lm_creDate = lm_creDate;
	}
	public String getLm_fileName() {
		try {
			if (lm_fileName != null && lm_fileName.length() != 0) {
				lm_fileName = URLDecoder.decode(lm_fileName, "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return lm_fileName;
		
	}
	public void setLm_fileName(String lm_fileName) {
		try {
			if(lm_fileName!= null && lm_fileName.length()!=0) {
				this.lm_fileName = URLEncoder.encode(lm_fileName,"UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		this.lm_fileName = lm_fileName;
	}
}
