package jbw.shop.services.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.CartPayDomain;
import jbw.shop.domain.Clothes;
import jbw.shop.domain.Clothes_Order_Map;
import jbw.shop.utils.ByteID;

public class CartPayed {
	private String oid;

	public List<CartPayDomain> addOrder(String user, List<String> mes,
			String mon) {
		double mons = Double.parseDouble(mon);
		List<CartPayDomain> list = new ArrayList<CartPayDomain>();

		List<Integer> num = new ArrayList<Integer>();
		List<Clothes> clothes = new ArrayList<Clothes>();

		ExecuteSQL esql = new ExecuteSQL();
		jbw.shop.domain.Order order = new jbw.shop.domain.Order();
		order.setO_tdate(new Date());
		oid = ByteID.uuid();
		order.setO_id(oid);
		order.setO_money(mons);
		order.setO_statu(0);
		order.setU_id(esql.queryUserByName(user).getU_id());
		esql.addOrder(order);
		try {
			for (int i = 0; i < mes.size(); i++) {
				Clothes_Order_Map com = new Clothes_Order_Map();
				if (i % 2 == 0) {
					com.setC_id(mes.get(i));
					CartPayDomain cpd = new CartPayDomain();
					Clothes cloes = esql.getClothesById(mes.get(i));
					clothes.add(cloes);
					com.setM_id(ByteID.uuid());
					com.setO_id(order.getO_id());
					esql.addOrderClo(com);
					cpd.setImage(cloes.getC_image());
					cpd.setName(cloes.getC_name());
					cpd.setPrice(cloes.getC_price());
					list.add(cpd);
				} else {
					com.setC_num(Integer.parseInt(mes.get(i)));
					num.add(Integer.parseInt(mes.get(i)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < num.size(); i++) {
			list.get(i).setNum(num.get(i));
		}
		return list;
	}

	public String getOid() {
		return oid;
	}
}
