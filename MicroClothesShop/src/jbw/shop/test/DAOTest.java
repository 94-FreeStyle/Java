package jbw.shop.test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.Clothes;
import jbw.shop.domain.Clothes_Order_Map;
import jbw.shop.domain.Clothes_User_Map;
import jbw.shop.domain.Order;
import jbw.shop.domain.User;
import jbw.shop.utils.ByteID;

import org.junit.Test;

public class DAOTest {
	ExecuteSQL esql = new ExecuteSQL();
	User user = null;

	/*
	 * User user = new User(108, "Tony", 16, "jbw994730", "jbw.ghost@qq.com",
	 * "15769398971", "f://q.jpg","甘肃兰州兰州理工大学");
	 */

	/*
	 * @Test // 测试增�?�删、改 public void test1() throws SQLException { run.add(user);
	 * }
	 * 
	 * @Test // 测试通过id单一User查询 public void test2() throws SQLException { user =
	 * run.queryUserById(101); System.out.println(user); }
	 * 
	 * @Test // 测试�?有User查询 public void test3() throws SQLException { List<User>
	 * list = run.queryAllUser(); for (User user : list) {
	 * System.out.println(user); } }
	 * 
	 * @Test // 测试�?有User的name列查�? public void test4() throws SQLException {
	 * List<Object> list = run.queryAllUserName(); for (Object name : list) {
	 * System.out.println(name); } }
	 * 
	 * @Test // 测试�?有User的name列查�? public void test5() throws SQLException { Long
	 * num = run.queryAllRecordNum(); System.out.println(num); }
	 * 
	 * @Test // 测试多表單一 查詢 public void test6() throws SQLException {
	 * Clothes_User_Map bu = run.queryBookUserMap(101, 1000000001);
	 * System.out.println(bu); }
	 * 
	 * @Test // 测试多表單一 查詢 public void test7() throws SQLException {
	 * List<Clothes_User_Map> buList = run.queryAllBookUser(101); for
	 * (Clothes_User_Map bu : buList) { System.out.println(bu); } }
	 */
	@Test
	// 测试通过id单一User查询
	public void test2() throws SQLException {
		user = esql.queryUserByName("kevin");
		System.out.println(user);
	}

	@Test
	// 测试通过id单一User查询
	public void test3() throws SQLException {

		long num = esql.getClothesCount();
		System.out.println(num);

		List<Clothes> list = esql.queryByPage(1, 8);
		for (Clothes c : list) {
			System.out.println(c.toString());
		}
	}

	@Test
	public void test4() {
		try {
			List<Clothes_User_Map> lis = new ExecuteSQL()
					.queryAllCart("Kevin2");
			System.out.println(lis.get(1).getC_id());
			;
			for (Clothes_User_Map cl : lis) {
				System.out.println(cl.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test5() {
		Clothes clothes = new Clothes();
		Random ran = new Random();
		for (int i = 0; i < 16; i++) {
			clothes.setC_id(ByteID.uuid());
			clothes.setC_name("特步夏季男士运动�?");
			clothes.setC_brand("特步");
			clothes.setC_color("橙色");
			clothes.setC_discount(8.8);
			clothes.setC_image("/MicroClothesShop/clothes_img/c" + i + ".jpg");
			clothes.setC_metra("棉布");
			clothes.setC_package("普�??");
			clothes.setC_people("男士");
			clothes.setC_price(ran.nextDouble() * 1000);
			clothes.setC_product("大英制衣�?");
			clothes.setC_sellednum(0);
			clothes.setC_semester("秋季");
			clothes.setC_size("ML");
			clothes.setC_style("运动");
			clothes.setC_surplusnum(786);
			try {
				esql.addClothes(clothes);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	public void test7() {
		Order or = new Order();
		or.setO_pdate(new Date());
		or.setO_id(ByteID.uuid());
		or.setO_money(389);
		or.setO_statu(0);
		or.setU_id("03715B4751D44936B4748290800E2177");
		esql.addOrder(or);
	}

	@Test
	public void test8() {
		Clothes_Order_Map or = new Clothes_Order_Map();
		or.setO_id("100");
		or.setC_num(10);
		or.setM_id(ByteID.uuid());
		or.setC_id("064E63341EDD4D5899AF111D8D15CB1C");

		esql.addOrderClo(or);
	}

	@Test
	public void test9() {
		List<Clothes_Order_Map> list = null;
		try {
			list = new ExecuteSQL()
					.getOrderCloth("048D064165B049AEBC23E9ACBB020948");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Clothes_Order_Map c : list) {
			System.out.println(c.toString());
		}
	}

	@Test
	public void Test10() {
		Integer inte = new Integer(23);

		System.out.println(inte.intValue());
	}
}
