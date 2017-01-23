package jbw.shop.services.user;

import java.sql.SQLException;
import java.util.Date;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.Clothes_Order_Map;
import jbw.shop.utils.ByteID;

public class BuyNow {
	public String addOrder(String user, String cid, int num) {
		ExecuteSQL esql = new ExecuteSQL();
		jbw.shop.domain.Order order = new jbw.shop.domain.Order();
		order.setO_tdate(new Date());
		order.setO_id(ByteID.uuid());
		try {
			order.setO_money(esql.getClothesById(cid).getC_price()*num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		order.setO_statu(0);
		order.setU_id(esql.queryUserByName(user).getU_id());
		esql.addOrder(order);

		Clothes_Order_Map com = new Clothes_Order_Map();
		com.setC_id(cid);
		com.setC_num(num);
		com.setM_id(ByteID.uuid());
		com.setO_id(order.getO_id());
		esql.addOrderClo(com);
		return order.getO_id();
	}
}
