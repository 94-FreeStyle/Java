package jbw.shop.domain;

import java.util.Date;

public class RuKuRecord {
	private String r_id;
	private String c_id;
	private String a_id;
	private int r_num;
	private Date r_date;

	public RuKuRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RuKuRecord(String r_id, String c_id, String a_id, int r_num,
			Date date) {
		super();
		this.r_id = r_id;
		this.c_id = c_id;
		this.a_id = a_id;
		this.r_num = r_num;
		this.r_date = date;
	}

	public String getR_id() {
		return r_id;
	}

	public void setR_id(String r_id) {
		this.r_id = r_id;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}

	public int getR_num() {
		return r_num;
	}

	public void setR_num(int r_num) {
		this.r_num = r_num;
	}

	public Date getR_date() {
		return r_date;
	}

	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}

}
