package jbw.shop.web.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.Clothes;
import jbw.shop.utils.MapBeanMapping;

public class EditedCloth extends HttpServlet {

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
		Clothes cloth=MapBeanMapping.toBean(request.getParameterMap(), Clothes.class);
		new ExecuteSQL().updateEditClothes(cloth);
		request.getRequestDispatcher("/servlet/QueryAllClothes").forward(request, response);
	}

}
