package jbw.shop.domain;

public class Clothes_Order_Map {
	private String m_id;
	private String c_id;
	private String o_id;
	private int c_num;
	private Clothes clothes;
	private Order order;

	public Clothes_Order_Map() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Clothes_Order_Map(String m_id, String c_id, String o_id, int c_num,
			Clothes clothes, Order order) {
		super();
		this.m_id = m_id;
		this.c_id = c_id;
		this.o_id = o_id;
		this.c_num = c_num;
		this.clothes = clothes;
		this.order = order;
	}

	@Override
	public String toString() {
		return "Clothes_Order_Map [m_id=" + m_id + ", c_id=" + c_id + ", o_id="
				+ o_id + ", c_num=" + c_num + ", clothes=" + clothes
				+ ", order=" + order + "]";
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getO_id() {
		return o_id;
	}

	public void setO_id(String o_id) {
		this.o_id = o_id;
	}

	public int getC_num() {
		return c_num;
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	public Clothes getClothes() {
		return clothes;
	}

	public void setClothes(Clothes clothes) {
		this.clothes = clothes;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
