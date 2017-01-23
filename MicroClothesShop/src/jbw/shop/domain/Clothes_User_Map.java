package jbw.shop.domain;

public class Clothes_User_Map {
	private String m_id;
	private String u_id;
	private String c_id;
	private int c_num;
	private int m_statu;
	private String packages;
	private Clothes clothes;
	private User user;

	public Clothes_User_Map() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Clothes_User_Map(String m_id, String u_id, String c_id, int c_num,
			int m_statu, String packages, Clothes clothes, User user) {
		super();
		this.m_id = m_id;
		this.u_id = u_id;
		this.c_id = c_id;
		this.c_num = c_num;
		this.m_statu = m_statu;
		this.packages = packages;
		this.clothes = clothes;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Clothes_User_Map [m_id=" + m_id + ", u_id=" + u_id + ", c_id="
				+ c_id + ", c_num=" + c_num + ", m_statu=" + m_statu
				+ ", packages=" + packages + ", clothes=" + clothes + ", user="
				+ user + "]";
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
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

	public int getM_statu() {
		return m_statu;
	}

	public void setM_statu(int m_statu) {
		this.m_statu = m_statu;
	}

	public String getPackages() {
		return packages;
	}

	public void setPackages(String packages) {
		this.packages = packages;
	}

	public Clothes getClothes() {
		return clothes;
	}

	public void setClothes(Clothes clothes) {
		this.clothes = clothes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
