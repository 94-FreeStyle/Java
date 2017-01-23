package jbw.shop.services.admin;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.User;

public class QueryUser {
	public String getUser(String name) {
		StringBuffer userobj = new StringBuffer();
		userobj.append("{User:[");

		try {
			User user = new ExecuteSQL().queryUserByName(name);

			userobj.append("{name:'" + user.getU_name() + "',mail:'"
					+ user.getU_mail() + "',phone:'" + user.getU_phone()
					+ "',address:'" + user.getU_address()
					+ "',bank:'" + user.getU_banknum()
					+ "',pw:'" + user.getU_pw()
					+ "'},");

			userobj.delete(userobj.length() - 1, userobj.length());
			userobj.append("]}");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userobj.toString();
	}
}
