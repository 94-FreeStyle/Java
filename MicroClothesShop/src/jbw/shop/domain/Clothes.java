package jbw.shop.domain;

public class Clothes {
	private String c_id;
	private String c_name;
	private String c_brand;
	private String c_product;
	private String c_size;
	private String c_style;
	private String c_color;
	private String c_metra;
	private String c_package;
	private int c_sellednum;
	private int c_surplusnum;
	private double c_price;
	private double c_discount;
	private String c_image;
	private String c_people;
	private String c_semester;

	public Clothes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Clothes(String c_id, String c_name, String c_brand,
			String c_product, String c_size, String c_style, String c_color,
			String c_metra, String c_package, int c_sellednum,
			int c_surplusnum, double c_price, double c_discount,
			String c_image, String c_people, String c_semester) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_brand = c_brand;
		this.c_product = c_product;
		this.c_size = c_size;
		this.c_style = c_style;
		this.c_color = c_color;
		this.c_metra = c_metra;
		this.c_package = c_package;
		this.c_sellednum = c_sellednum;
		this.c_surplusnum = c_surplusnum;
		this.c_price = c_price;
		this.c_discount = c_discount;
		this.c_image = c_image;
		this.c_people = c_people;
		this.c_semester = c_semester;
	}

	@Override
	public String toString() {
		return "Clothes [c_id=" + c_id + ", c_name=" + c_name + ", c_brand="
				+ c_brand + ", c_product=" + c_product + ", c_size=" + c_size
				+ ", c_style=" + c_style + ", c_color=" + c_color
				+ ", c_metra=" + c_metra + ", c_package=" + c_package
				+ ", c_sellednum=" + c_sellednum + ", c_surplusnum="
				+ c_surplusnum + ", c_price=" + c_price + ", c_discount="
				+ c_discount + ", c_image=" + c_image + ", c_people="
				+ c_people + ", c_semester=" + c_semester + "]";
	}

	public double getC_discount() {
		return c_discount;
	}

	public void setC_discount(double c_discount) {
		this.c_discount = c_discount;
	}

	public double getC_price() {
		return c_price;
	}

	public void setC_price(double c_price) {
		this.c_price = c_price;
	}

	public String getC_image() {
		return c_image;
	}

	public void setC_image(String c_image) {
		this.c_image = c_image;
	}

	public String getC_people() {
		return c_people;
	}

	public void setC_people(String c_people) {
		this.c_people = c_people;
	}

	public String getC_semester() {
		return c_semester;
	}

	public void setC_semester(String c_semester) {
		this.c_semester = c_semester;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_brand() {
		return c_brand;
	}

	public void setC_brand(String c_brand) {
		this.c_brand = c_brand;
	}

	public String getC_product() {
		return c_product;
	}

	public void setC_product(String c_product) {
		this.c_product = c_product;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getC_size() {
		return c_size;
	}

	public void setC_size(String c_size) {
		this.c_size = c_size;
	}

	public String getC_style() {
		return c_style;
	}

	public void setC_style(String c_style) {
		this.c_style = c_style;
	}

	public String getC_color() {
		return c_color;
	}

	public void setC_color(String c_color) {
		this.c_color = c_color;
	}

	public String getC_metra() {
		return c_metra;
	}

	public void setC_metra(String c_metra) {
		this.c_metra = c_metra;
	}

	public String getC_package() {
		return c_package;
	}

	public void setC_package(String c_package) {
		this.c_package = c_package;
	}

	public int getC_sellednum() {
		return c_sellednum;
	}

	public void setC_sellednum(int c_sellednum) {
		this.c_sellednum = c_sellednum;
	}

	public int getC_surplusnum() {
		return c_surplusnum;
	}

	public void setC_surplusnum(int c_surplusnum) {
		this.c_surplusnum = c_surplusnum;
	}

}
