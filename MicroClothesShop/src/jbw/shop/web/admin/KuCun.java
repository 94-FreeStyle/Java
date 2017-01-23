package jbw.shop.web.admin;

import java.io.IOException;
import java.sql.SQLException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.Clothes;

public class KuCun extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ExecuteSQL esql = new ExecuteSQL();

		List<Clothes> clothes = null;
		try {
			clothes = esql.queryAllClothes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("clothes", clothes);
		request.getRequestDispatcher(
				"/WEB-INF/AdminJSP/AMR_QueryAllKucunRecord.jsp").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
