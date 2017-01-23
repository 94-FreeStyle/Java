package jbw.shop.domain;

public class CartPayDomain {
	private int num = 0;
	private String image;
	private String name;
	private double price;
	private double dmoney;

	public double getDmoney() {
		dmoney=price*num;
		return dmoney;
	}

	public void setDmoney(double dmoney) {
		this.dmoney = dmoney;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
