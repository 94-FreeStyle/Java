package jbw.shop.domain;

public class ShoppingCart {
	private String c_id;
	private int c_num;
	private String c_name;
	private String c_image;
	private double c_price;

	@Override
	public String toString() {
		return "ShoppingCart [c_id=" + c_id + ", c_num=" + c_num + ", c_name=" + c_name + ", c_image=" + c_image
				+ ", c_price=" + c_price + "]";
	}

	public double getC_money() {
		return c_num * c_price;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public int getC_num() {
		return c_num;
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_image() {
		return c_image;
	}

	public void setC_image(String c_image) {
		this.c_image = c_image;
	}

	public double getC_price() {
		return c_price;
	}

	public void setC_price(double c_price) {
		this.c_price = c_price;
	}

}
