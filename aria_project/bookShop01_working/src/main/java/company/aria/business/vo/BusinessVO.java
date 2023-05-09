package company.aria.business.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("businessVO")
public class BusinessVO {
	private String bu_id;	
	private String bu_pw;
	private String bu_bn;
	private String bu_ssn1;	
	private String bu_ssn2;	
	private String bu_name;	
	private String bu_email_yes;	
	private String bu_email;	
	public String getBu_email() {
		bu_email=bu_email1+"@"+bu_email2;
		return bu_email;
	}
	private String bu_email1;	
	private String bu_email2;	
	private String bu_sms_yes;	
	private String bu_phone1;	
	private String bu_phone2;	
	private String bu_phone3;	
	private int bu_zipcode;	
	private String bu_address1;	
	private String bu_address2;	
	private String bu_lack_yes;	
	private String bu_care_yes;	
	private String bu_female_yes;	
	private String bu_certified;	
	private Date bu_creDate;	
	private String bu_kakao_log_yes;	
	private String bu_kakao_log_conDate;	
	private String bu_kakao_log_id;
	private String bu_deleted;
	private String bu_note;
	public String getBu_id() {
		return bu_id;
	}
	public void setBu_id(String bu_id) {
		this.bu_id = bu_id;
	}
	public String getBu_pw() {
		return bu_pw;
	}
	public void setBu_pw(String bu_pw) {
		this.bu_pw = bu_pw;
	}
	public String getBu_bn() {
		return bu_bn;
	}
	public void setBu_bn(String bu_bn) {
		this.bu_bn = bu_bn;
	}
	public String getBu_ssn1() {
		return bu_ssn1;
	}
	public void setBu_ssn1(String bu_ssn1) {
		this.bu_ssn1 = bu_ssn1;
	}
	public String getBu_ssn2() {
		return bu_ssn2;
	}
	public void setBu_ssn2(String bu_ssn2) {
		this.bu_ssn2 = bu_ssn2;
	}
	public String getBu_name() {
		return bu_name;
	}
	public void setBu_name(String bu_name) {
		this.bu_name = bu_name;
	}
	public String getBu_email_yes() {
		return bu_email_yes;
	}
	public void setBu_email_yes(String bu_email_yes) {
		this.bu_email_yes = bu_email_yes;
	}
	public String getBu_email1() {
		return bu_email1;
	}
	public void setBu_email1(String bu_email1) {
		this.bu_email1 = bu_email1;
	}
	public String getBu_email2() {
		return bu_email2;
	}
	public void setBu_email2(String bu_email2) {
		this.bu_email2 = bu_email2;
	}
	public String getBu_sms_yes() {
		return bu_sms_yes;
	}
	public void setBu_sms_yes(String bu_sms_yes) {
		this.bu_sms_yes = bu_sms_yes;
	}
	public String getBu_phone1() {
		return bu_phone1;
	}
	public void setBu_phone1(String bu_phone1) {
		this.bu_phone1 = bu_phone1;
	}
	public String getBu_phone2() {
		return bu_phone2;
	}
	public void setBu_phone2(String bu_phone2) {
		this.bu_phone2 = bu_phone2;
	}
	public String getBu_phone3() {
		return bu_phone3;
	}
	public void setBu_phone3(String bu_phone3) {
		this.bu_phone3 = bu_phone3;
	}
	public int getBu_zipcode() {
		return bu_zipcode;
	}
	public void setBu_zipcode(int bu_zipcode) {
		this.bu_zipcode = bu_zipcode;
	}
	public String getBu_address1() {
		return bu_address1;
	}
	public void setBu_address1(String bu_address1) {
		this.bu_address1 = bu_address1;
	}
	public String getBu_address2() {
		return bu_address2;
	}
	public void setBu_address2(String bu_address2) {
		this.bu_address2 = bu_address2;
	}
	public String getBu_lack_yes() {
		return bu_lack_yes;
	}
	public void setBu_lack_yes(String bu_lack_yes) {
		this.bu_lack_yes = bu_lack_yes;
	}
	public String getBu_care_yes() {
		return bu_care_yes;
	}
	public void setBu_care_yes(String bu_care_yes) {
		this.bu_care_yes = bu_care_yes;
	}
	public String getBu_female_yes() {
		return bu_female_yes;
	}
	public void setBu_female_yes(String bu_female_yes) {
		this.bu_female_yes = bu_female_yes;
	}
	public String getBu_certified() {
		return bu_certified;
	}
	public void setBu_certified(String bu_certified) {
		this.bu_certified = bu_certified;
	}
	public Date getBu_creDate() {
		return bu_creDate;
	}
	public void setBu_creDate(Date bu_creDate) {
		this.bu_creDate = bu_creDate;
	}
	public String getBu_kakao_log_yes() {
		return bu_kakao_log_yes;
	}
	public void setBu_kakao_log_yes(String bu_kakao_log_yes) {
		this.bu_kakao_log_yes = bu_kakao_log_yes;
	}
	public String getBu_kakao_log_conDate() {
		return bu_kakao_log_conDate;
	}
	public void setBu_kakao_log_conDate(String bu_kakao_log_conDate) {
		this.bu_kakao_log_conDate = bu_kakao_log_conDate;
	}
	public String getBu_kakao_log_id() {
		return bu_kakao_log_id;
	}
	public void setBu_kakao_log_id(String bu_kakao_log_id) {
		this.bu_kakao_log_id = bu_kakao_log_id;
	}
	public String getBu_deleted() {
		return bu_deleted;
	}
	public void setBu_deleted(String bu_deleted) {
		this.bu_deleted = bu_deleted;
	}
	public String getBu_note() {
		return bu_note;
	}
	public void setBu_note(String bu_note) {
		this.bu_note = bu_note;
	}
	
}
