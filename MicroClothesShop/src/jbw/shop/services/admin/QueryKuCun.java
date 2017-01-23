package jbw.shop.services.admin;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.Clothes;

public class QueryKuCun {
	public String getCloth(String cid) {
		StringBuffer userobj = new StringBuffer();
		userobj.append("{Cloth:[");

		try {
			Clothes cloth = new ExecuteSQL().getClothesById(cid);

			userobj.append("{id:'" + cloth.getC_id() + "',name:'"
					+ cloth.getC_name() + "',price:'" + cloth.getC_price()
					+ "',brand:'" + cloth.getC_brand() + "',discount:'"
					+ cloth.getC_discount() + "',surplus:'"
					+ cloth.getC_surplusnum() + "'},");

			userobj.delete(userobj.length() - 1, userobj.length());
			userobj.append("]}");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userobj.toString();
	}
}
