package jbw.shop.services.user;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.User;
import jbw.shop.utils.ImageVCode;
import jbw.shop.utils.MD5PW;

public class UserRegister {
	public String register(User user, String repw, String checkC) {
		ExecuteSQL exs = new ExecuteSQL();
		String vcode = ImageVCode.value;
		boolean flag = exs.isExist(user.getU_name());
		if (flag) {
			if (vcode.equalsIgnoreCase(checkC)) {
				user.setU_pw(MD5PW.strToMD5(user.getU_pw()));
				exs.addUser(user);
				return "ok";
			} else {
				return "nosame";
			}
		} else {
			return "exits";
		}
	}
}
