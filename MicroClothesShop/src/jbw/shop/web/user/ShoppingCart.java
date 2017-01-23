package jbw.shop.web.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.services.user.ShowCart;

public class ShoppingCart extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = (String) request.getSession().getAttribute("userss");
		double money=0;
		List<jbw.shop.domain.ShoppingCart> datas = new ShowCart()
				.showCart(user);
		for(jbw.shop.domain.ShoppingCart ss:datas){
			money=money+ss.getC_money();
		}
		request.setAttribute("user", new ExecuteSQL().queryUserByName(user));
		request.setAttribute("carts", datas);
		request.setAttribute("money", money);
		request.getRequestDispatcher("/WEB-INF/UserJSP/ShoppingCart.jsp")
				.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
