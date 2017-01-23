package jbw.shop.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbw.shop.domain.Clothes;
import jbw.shop.utils.MapBeanMapping;

public class QueryClothes extends HttpServlet {

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

		Clothes par = MapBeanMapping.toBean(request.getParameterMap(),
				Clothes.class);
		StringBuilder url = new StringBuilder();
		String brand = par.getC_brand();
		if (brand != null && !brand.trim().isEmpty()) {
			if (request.getMethod().equalsIgnoreCase("get")) {
				brand = new String(brand.getBytes("iso-8859-1"), "utf-8");
				par.setC_brand(brand);
			}
			url.append("&c_brand=" + brand);
		}
		String color = par.getC_color();
		if (color != null && !color.trim().isEmpty()) {
			if (request.getMethod().equalsIgnoreCase("get")) {
				color = new String(color.getBytes("iso-8859-1"), "utf-8");
				par.setC_color(color);
			}
			url.append("&c_color=" + color);
		}
		String style = par.getC_style();
		if (style != null && !style.trim().isEmpty()) {
			if (request.getMethod().equalsIgnoreCase("get")) {
				style = new String(style.getBytes("iso-8859-1"), "utf-8");
				par.setC_style(style);
			}
			url.append("&c_style=" + style);
		}
		double price = par.getC_price();
		if (!(price < 0)) {
			url.append("&c_price=" + price);
		}
		double mp = 100000.0;
		String p = request.getParameter("c_maxprice");
		if (p != null && !p.trim().isEmpty()) {
			mp = Double.parseDouble(p);
		} else {
		}
		int pageCode = 1;
		String s = request.getParameter("pageCode");

		if (s != null && !s.trim().isEmpty()) {
			pageCode = Integer.parseInt(s);
		} else {
		}
		request.setAttribute("pb", new jbw.shop.services.user.QueryClothes()
				.queryByPage(par, mp, pageCode));
		request.setAttribute("url", url.toString());
		request.getRequestDispatcher("/WEB-INF/UserJSP/UserMain_ZURight.jsp")
				.forward(request, response);
	}
}
