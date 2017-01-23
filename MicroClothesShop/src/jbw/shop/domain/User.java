package jbw.shop.domain;

public class User {
	private String u_id;
	private String u_name;
	private int u_glory;
	private String u_pw;
	private String u_mail;
	private String u_phone;
	private String u_code;
	private String u_tax;
	private String u_bankname;
	private String u_banknum;
	private String u_address;
	private String u_sex;
	private double u_cmoney;
	private String u_image;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String u_id, String u_name, int u_glory, String u_pw,
			String u_mail, String u_phone, String u_code, String u_tax,
			String u_bankname, String u_banknum, String u_address,
			String u_sex, double u_cmoney, String u_image) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_glory = u_glory;
		this.u_pw = u_pw;
		this.u_mail = u_mail;
		this.u_phone = u_phone;
		this.u_code = u_code;
		this.u_tax = u_tax;
		this.u_bankname = u_bankname;
		this.u_banknum = u_banknum;
		this.u_address = u_address;
		this.u_sex = u_sex;
		this.u_cmoney = u_cmoney;
		this.u_image = u_image;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_name=" + u_name + ", u_glory="
				+ u_glory + ", u_pw=" + u_pw + ", u_mail=" + u_mail
				+ ", u_phone=" + u_phone + ", u_code=" + u_code + ", u_tax="
				+ u_tax + ", u_bankname=" + u_bankname + ", u_banknum="
				+ u_banknum + ", u_address=" + u_address + ", u_sex=" + u_sex
				+ ", u_cmoney=" + u_cmoney + ", u_image=" + u_image + "]";
	}

	public String getU_image() {
		return u_image;
	}

	public void setU_image(String u_image) {
		this.u_image = u_image;
	}

	public double getU_cmoney() {
		return u_cmoney;
	}

	public void setU_cmoney(double u_cmoney) {
		this.u_cmoney = u_cmoney;
	}

	public String getU_sex() {
		return u_sex;
	}

	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public int getU_glory() {
		return u_glory;
	}

	public void setU_glory(int u_glory) {
		this.u_glory = u_glory;
	}

	public String getU_pw() {
		return u_pw;
	}

	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}

	public String getU_mail() {
		return u_mail;
	}

	public void setU_mail(String u_mail) {
		this.u_mail = u_mail;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public String getU_code() {
		return u_code;
	}

	public void setU_code(String u_code) {
		this.u_code = u_code;
	}

	public String getU_tax() {
		return u_tax;
	}

	public void setU_tax(String u_tax) {
		this.u_tax = u_tax;
	}

	public String getU_bankname() {
		return u_bankname;
	}

	public void setU_bankname(String u_bankname) {
		this.u_bankname = u_bankname;
	}

	public String getU_banknum() {
		return u_banknum;
	}

	public void setU_banknum(String u_banknum) {
		this.u_banknum = u_banknum;
	}

	public String getU_address() {
		return u_address;
	}

	public void setU_address(String u_address) {
		this.u_address = u_address;
	}

}
