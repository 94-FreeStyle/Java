package jbw.shop.services.user;

import java.sql.SQLException;
import java.util.List;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.Clothes;
import jbw.shop.domain.PageBean;

public class QueryClothes {
	public PageBean<Clothes> queryByPage(Clothes criteria,double mp,int pageCode) {
		PageBean<Clothes> pb =null;
		List<Clothes> datas = null;
		try {
			ExecuteSQL esq = new ExecuteSQL();
			int totleRecord = (int) esq.getMCount(criteria,mp);
			pb = new PageBean<Clothes>(pageCode, totleRecord);
			datas = esq.queryzuByPage(criteria,mp,(pageCode - 1) * pb.getPageSize(),
					pb.getPageSize());
			pb.setDatas(datas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pb;
	}
}
