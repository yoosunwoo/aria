package company.aria.member.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;
@Component("memberVO")
public class MemberVO {
	private String me_id;	
	private String me_pw;	
	private String me_ssn1;	
	private String me_ssn2;	
	private String me_name;	
	private String me_gender;	
	private int me_age;	
	private String me_age_range;	
	private String me_email_yes;	
	private String me_email;	
	public String getMe_email() {
		me_email=me_email1+"@"+me_email2;
		return me_email;
	}
	private String me_email1;	
	private String me_email2;	
	private String me_sms_yes;	
	private String me_phone1;	
	private String me_phone2;	
	private String me_phone3;	
	private int me_zipcode;	
	private String me_address1;	
	private String me_address2;	
	private String me_lack_yes;	
	private String me_care_yes;	
	private String me_female_yes;	
	private Date me_creDate;	
	private String me_deleted;	
	private String me_cardNo;
	private String me_balance;
	public String getMe_cardNo() {
		return me_cardNo;
	}
	public void setMe_cardNo(String me_cardNo) {
		this.me_cardNo = me_cardNo;
	}
	public String getMe_balance() {
		return me_balance;
	}
	public void setMe_balance(String me_balance) {
		this.me_balance = me_balance;
	}
	private String me_kakao_log_yes;	
	private String me_kakao_log_conDate;	
	private String me_kakao_log_id;	
	private String me_note;
	public String getMe_id() {
		return me_id;
	}
	public void setMe_id(String me_id) {
		this.me_id = me_id;
	}
	public String getMe_pw() {
		return me_pw;
	}
	public void setMe_pw(String me_pw) {
		this.me_pw = me_pw;
	}
	public String getMe_ssn1() {
		return me_ssn1;
	}
	public void setMe_ssn1(String me_ssn1) {
		this.me_ssn1 = me_ssn1;
	}
	public String getMe_ssn2() {
		return me_ssn2;
	}
	public void setMe_ssn2(String me_ssn2) {
		this.me_ssn2 = me_ssn2;
	}
	public String getMe_name() {
		return me_name;
	}
	public void setMe_name(String me_name) {
		this.me_name = me_name;
	}
	public String getMe_gender() {
		return me_gender;
	}
	public void setMe_gender(String me_gender) {
		this.me_gender = me_gender;
	}
	public int getMe_age() {
		return me_age;
	}
	public void setMe_age(int me_age) {
		this.me_age = me_age;
	}
	public String getMe_age_range() {
		return me_age_range;
	}
	public void setMe_age_range(String me_age_range) {
		this.me_age_range = me_age_range;
	}
	public String getMe_email_yes() {
		return me_email_yes;
	}
	public void setMe_email_yes(String me_email_yes) {
		this.me_email_yes = me_email_yes;
	}
	public String getMe_email1() {
		return me_email1;
	}
	public void setMe_email1(String me_email1) {
		this.me_email1 = me_email1;
	}
	public String getMe_email2() {
		return me_email2;
	}
	public void setMe_email2(String me_email2) {
		this.me_email2 = me_email2;
	}
	public String getMe_sms_yes() {
		return me_sms_yes;
	}
	public void setMe_sms_yes(String me_sms_yes) {
		this.me_sms_yes = me_sms_yes;
	}
	public String getMe_phone1() {
		return me_phone1;
	}
	public void setMe_phone1(String me_phone1) {
		this.me_phone1 = me_phone1;
	}
	public String getMe_phone2() {
		return me_phone2;
	}
	public void setMe_phone2(String me_phone2) {
		this.me_phone2 = me_phone2;
	}
	public String getMe_phone3() {
		return me_phone3;
	}
	public void setMe_phone3(String me_phone3) {
		this.me_phone3 = me_phone3;
	}
	public int getMe_zipcode() {
		return me_zipcode;
	}
	public void setMe_zipcode(int me_zipcode) {
		this.me_zipcode = me_zipcode;
	}
	public String getMe_address1() {
		return me_address1;
	}
	public void setMe_address1(String me_address1) {
		this.me_address1 = me_address1;
	}
	public String getMe_address2() {
		return me_address2;
	}
	public void setMe_address2(String me_address2) {
		this.me_address2 = me_address2;
	}
	public String getMe_lack_yes() {
		return me_lack_yes;
	}
	public void setMe_lack_yes(String me_lack_yes) {
		this.me_lack_yes = me_lack_yes;
	}
	public String getMe_care_yes() {
		return me_care_yes;
	}
	public void setMe_care_yes(String me_care_yes) {
		this.me_care_yes = me_care_yes;
	}
	public String getMe_female_yes() {
		return me_female_yes;
	}
	public void setMe_female_yes(String me_female_yes) {
		this.me_female_yes = me_female_yes;
	}
	public Date getMe_creDate() {
		return me_creDate;
	}
	public void setMe_creDate(Date me_creDate) {
		this.me_creDate = me_creDate;
	}
	public String getMe_deleted() {
		return me_deleted;
	}
	public void setMe_deleted(String me_deleted) {
		this.me_deleted = me_deleted;
	}
	public String getMe_kakao_log_yes() {
		return me_kakao_log_yes;
	}
	public void setMe_kakao_log_yes(String me_kakao_log_yes) {
		this.me_kakao_log_yes = me_kakao_log_yes;
	}
	public String getMe_kakao_log_conDate() {
		return me_kakao_log_conDate;
	}
	public void setMe_kakao_log_conDate(String me_kakao_log_conDate) {
		this.me_kakao_log_conDate = me_kakao_log_conDate;
	}
	public String getMe_kakao_log_id() {
		return me_kakao_log_id;
	}
	public void setMe_kakao_log_id(String me_kakao_log_id) {
		//if (me_kakao_log_id == null || me_kakao_log_id == 0L) this.me_kakao_log_id = 0L; 
		this.me_kakao_log_id = me_kakao_log_id;
	}
	public String getMe_note() {
		return me_note;
	}
	public void setMe_note(String me_note) {
		this.me_note = me_note;
	}	
	
}
