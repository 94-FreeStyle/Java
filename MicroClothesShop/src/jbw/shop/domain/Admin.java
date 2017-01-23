package jbw.shop.domain;

import java.util.Date;

public class Admin {
	private String a_id;
	private String a_name;
	private String a_mail;
	private String a_phone;
	private String a_pw;
	private Date a_lt;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String a_id, String a_name, String a_mail, String a_phone,
			String a_pw, Date a_lt) {
		super();
		this.a_id = a_id;
		this.a_name = a_name;
		this.a_mail = a_mail;
		this.a_phone = a_phone;
		this.a_pw = a_pw;
		this.a_lt = a_lt;
	}

	@Override
	public String toString() {
		return "Admin [a_id=" + a_id + ", a_name=" + a_name + ", a_mail="
				+ a_mail + ", a_phone=" + a_phone + ", a_pw=" + a_pw
				+ ", a_lt=" + a_lt + "]";
	}

	public Date getA_lt() {
		return a_lt;
	}

	public void setA_lt(Date a_lt) {
		this.a_lt = a_lt;
	}

	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

	public String getA_mail() {
		return a_mail;
	}

	public void setA_mail(String a_mail) {
		this.a_mail = a_mail;
	}

	public String getA_phone() {
		return a_phone;
	}

	public void setA_phone(String a_phone) {
		this.a_phone = a_phone;
	}

	public String getA_pw() {
		return a_pw;
	}

	public void setA_pw(String a_pw) {
		this.a_pw = a_pw;
	}

}
