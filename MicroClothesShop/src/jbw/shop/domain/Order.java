package jbw.shop.domain;

import java.util.Date;

public class Order {
	private String o_id;
	private String u_id;
	private int o_statu;
	private Date o_tdate;
	private Date o_pdate;
	private Date o_qdate;
	private Date o_fdate;
	private double o_money;
	private String a_id;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(String o_id, String u_id, int o_statu, Date o_tdate,
			Date o_pdate, Date o_qdate, Date o_fdate, double o_money,
			String a_id) {
		super();
		this.o_id = o_id;
		this.u_id = u_id;
		this.o_statu = o_statu;
		this.o_tdate = o_tdate;
		this.o_pdate = o_pdate;
		this.o_qdate = o_qdate;
		this.o_fdate = o_fdate;
		this.o_money = o_money;
		this.a_id = a_id;
	}

	@Override
	public String toString() {
		return "Order [o_id=" + o_id + ", u_id=" + u_id + ", o_statu="
				+ o_statu + ", o_tdate=" + o_tdate + ", o_pdate=" + o_pdate
				+ ", o_qdate=" + o_qdate + ", o_fdate=" + o_fdate
				+ ", o_money=" + o_money + ", a_id=" + a_id + "]";
	}

	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}

	public String getO_id() {
		return o_id;
	}

	public void setO_id(String o_id) {
		this.o_id = o_id;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public int getO_statu() {
		return o_statu;
	}

	public void setO_statu(int o_statu) {
		this.o_statu = o_statu;
	}

	public Date getO_tdate() {
		return o_tdate;
	}

	public void setO_tdate(Date o_tdate) {
		this.o_tdate = o_tdate;
	}

	public Date getO_pdate() {
		return o_pdate;
	}

	public void setO_pdate(Date o_pdate) {
		this.o_pdate = o_pdate;
	}

	public Date getO_qdate() {
		return o_qdate;
	}

	public void setO_qdate(Date o_qdate) {
		this.o_qdate = o_qdate;
	}

	public Date getO_fdate() {
		return o_fdate;
	}

	public void setO_fdate(Date o_fdate) {
		this.o_fdate = o_fdate;
	}

	public double getO_money() {
		return o_money;
	}

	public void setO_money(double o_money) {
		this.o_money = o_money;
	}

}
