package jbw.shop.web.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.services.user.BuyNow;

public class Buy extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("cid");
		String user = (String) request.getSession().getAttribute("userss");
		request.setAttribute("user", new ExecuteSQL().queryUserByName(user));
		int num = Integer.parseInt(request.getParameter("num"));
		double mon = 0;
		String oid = new BuyNow().addOrder(user, cid, num);

		try {
			mon = new ExecuteSQL().getClothesById(cid).getC_price() * num;
			request.setAttribute("buyClo", new ExecuteSQL().getClothesById(cid));
			request.setAttribute("address","&nbsp;&nbsp;地址�?"+
					new ExecuteSQL().queryUserByName(user).getU_address()
							+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 邮编�? "
							+ new ExecuteSQL().queryUserByName(user)
									.getU_code()
							+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话�? "
							+ new ExecuteSQL().queryUserByName(user)
									.getU_phone());
			request.setAttribute("oid", oid);
			request.setAttribute("mon", mon);
			request.setAttribute("numm", num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/UserJSP/Pay.jsp").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
