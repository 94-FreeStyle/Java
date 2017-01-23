package jbw.shop.web.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.Clothes;

public class UpdateKuCun extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("cid");
		String snum = request.getParameter("num");
		int num = Integer.parseInt(snum);
		ExecuteSQL esql = new ExecuteSQL();
		try {
			Clothes cloth = esql.getClothesById(cid);
			int nnum = cloth.getC_surplusnum() + num;
			esql.updateKucun(nnum, cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
