package jbw.shop.web.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.Clothes_User_Map;
import jbw.shop.domain.User;

public class CartChanged extends HttpServlet {

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
		ExecuteSQL sqlq = new ExecuteSQL();
		String snum = request.getParameter("num");
		int num = Integer.parseInt(snum);
		String usern = (String) request.getSession().getAttribute("userss");
		User user = sqlq.queryUserByName(usern);
		double a = 0;
		int b = 0;
		double mon1 = 0;
		if (num != 0) {
			for (int i = 0; i < num; i++) {
				Clothes_User_Map cum = null;
				String cid = request.getParameter("s" + i);
				if (!cid.equalsIgnoreCase("xxxx")) {
					try {
						cum = sqlq.getCUMClothNum(user.getU_id(), cid);
						a = sqlq.getClothesById(cid).getC_price();
						b = cum.getC_num();
						mon1 = mon1 + a * b;
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {

				}
			}
			response.getWriter().write("" + mon1);
		} else {
		}
	}

}
