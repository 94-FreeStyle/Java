package jbw.shop.web.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.TuiOrder;

public class TuiRecord extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ExecuteSQL esql = new ExecuteSQL();
		try {
			List<TuiOrder> list = esql.getAllTuiRecord();
			request.setAttribute("tui", list);
			request.getRequestDispatcher("/WEB-INF/AdminJSP/AMR_TuiRecord.jsp")
					.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
