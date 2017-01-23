package jbw.shop.domain;

import java.util.Date;

public class TuiOrder {
	private String t_id;
	private String o_id;
	private String t_reson;
	private String a_id;
	private Date t_date;
	private Date t_odate = new Date();
	private double o_money;
	private String u_id;

	public TuiOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TuiOrder(String t_id, String o_id, String t_reson, String a_id,
			Date t_date, Date t_odate, double o_money, String u_id) {
		super();
		this.t_id = t_id;
		this.o_id = o_id;
		this.t_reson = t_reson;
		this.a_id = a_id;
		this.t_date = t_date;
		this.t_odate = t_odate;
		this.o_money = o_money;
		this.u_id = u_id;
	}

	@Override
	public String toString() {
		return "TuiOrder [t_id=" + t_id + ", o_id=" + o_id + ", t_reson="
				+ t_reson + ", a_id=" + a_id + ", t_date=" + t_date
				+ ", t_odate=" + t_odate + ", o_money=" + o_money + ", u_id="
				+ u_id + "]";
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public double getO_money() {
		return o_money;
	}

	public void setO_money(double o_money) {
		this.o_money = o_money;
	}

	public Date getT_odate() {
		return t_odate;
	}

	public void setT_odate(Date t_odate) {
		this.t_odate = t_odate;
	}

	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}

	public String getT_reson() {
		return t_reson;
	}

	public void setT_reson(String t_reson) {
		this.t_reson = t_reson;
	}

	public String getT_id() {
		return t_id;
	}

	public void setT_id(String t_id) {
		this.t_id = t_id;
	}

	public String getO_id() {
		return o_id;
	}

	public void setO_id(String o_id) {
		this.o_id = o_id;
	}

	public Date getT_date() {
		return t_date;
	}

	public void setT_date(Date t_date) {
		this.t_date = t_date;
	}

}
