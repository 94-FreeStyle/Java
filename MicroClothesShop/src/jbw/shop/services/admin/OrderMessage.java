package jbw.shop.services.admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.Clothes;
import jbw.shop.domain.Clothes_Order_Map;

public class OrderMessage {
	List<Integer> nums = new ArrayList<Integer>();

	public List<Clothes> getOrederMess(String oid) {
		ExecuteSQL esql = new ExecuteSQL();
		List<Clothes_Order_Map> coml = null;
		List<String> cids = new ArrayList<String>();
		List<Clothes> clothes = new ArrayList<Clothes>();
		try {
			coml = esql.getOrderCloth(oid);
			for (Clothes_Order_Map cid : coml) {
				cids.add(cid.getC_id());
				nums.add(cid.getC_num());
			}
			for (int i = 0; i < cids.size(); i++) {
				clothes.add(esql.getClothesById(cids.get(i)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clothes;
	}

	public List<Integer> getNum() {
		return nums;
	}
}
