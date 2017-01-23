package jbw.shop.services.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.Clothes_User_Map;
import jbw.shop.domain.ShoppingCart;

public class ShowCart {
	public List<ShoppingCart> showCart(String user) {
		ExecuteSQL exs = new ExecuteSQL();

		List<ShoppingCart> clol = new ArrayList<ShoppingCart>();
		try {
			List<Clothes_User_Map> cartList = exs.queryAllCart(user);
			for (Clothes_User_Map cum : cartList) {
				ShoppingCart sp = new ShoppingCart();
				sp.setC_id(cum.getC_id());
				sp.setC_image(exs.getClothesById(cum.getC_id()).getC_image());
				sp.setC_name(exs.getClothesById(cum.getC_id()).getC_name());
				sp.setC_num(cum.getC_num());
				sp.setC_price(exs.getClothesById(cum.getC_id()).getC_price());
				clol.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clol;
	}
}
