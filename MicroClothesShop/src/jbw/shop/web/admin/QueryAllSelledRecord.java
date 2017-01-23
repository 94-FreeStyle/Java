package jbw.shop.web.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.Clothes;
import jbw.shop.domain.SellRecord;

public class QueryAllSelledRecord extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ExecuteSQL esql = new ExecuteSQL();
		List<SellRecord> records = new ArrayList<SellRecord>();
		List<Clothes> clothes = null;
		double  money=0;
		try {
			clothes = esql.queryAllClothes();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 0; i < clothes.size(); i++) {
			SellRecord record = new SellRecord();
			record.setBrand(clothes.get(i).getC_brand());
			record.setDiscount(clothes.get(i).getC_discount());
			record.setMoney(clothes.get(i).getC_price()
					* clothes.get(i).getC_sellednum());
			money=money+record.getMoney();
			record.setName(clothes.get(i).getC_name());
			record.setNum(clothes.get(i).getC_sellednum());
			record.setPrice(clothes.get(i).getC_price());
			records.add(record);
		}

		request.setAttribute("records", records);
		request.setAttribute("money", money);
		request.getRequestDispatcher(
				"/WEB-INF/AdminJSP/AMR_QueryAllSellRecord.jsp").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
