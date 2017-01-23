package jbw.shop.domain;

public class SellRecord {
	private String name;
	private double price;
	private String brand;
	private double discount;
	private int num;
	private double money;

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

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discout) {
		this.discount = discout;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

}
