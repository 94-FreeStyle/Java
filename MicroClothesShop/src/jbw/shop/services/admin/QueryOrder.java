package jbw.shop.services.admin;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.Order;

public class QueryOrder {
	public String getOrder(String id) {
		StringBuffer userobj = new StringBuffer();
		userobj.append("{Order:[");

		try {
			Order order = new ExecuteSQL().getOrderById(id);

			userobj.append("{id:'" + order.getO_id() + "',date:'"
					+ order.getO_tdate() + "',money:'" + order.getO_money()
					+ "',user:'" + order.getU_id()+ "',opt:'" + order.getA_id() + "',statu:'"
					+ order.getO_statu() + "'},");

			userobj.delete(userobj.length() - 1, userobj.length());
			userobj.append("]}");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userobj.toString();
	}

}
