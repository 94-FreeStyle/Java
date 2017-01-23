package jbw.shop.web.admin;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.Admin;

public class Welcome extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String an = (String) request.getSession().getAttribute("adminn");
		Admin admin = new ExecuteSQL().queryAdminByName(an);
		request.setAttribute("guan", admin);
		String day = null;
		@SuppressWarnings("deprecation")
		int hour=new Date().getHours();
		if(hour>12&&hour<18){
			day="中午�?";
		}else if(hour>0&&hour<12){
			day="早上�?";
		}else if(hour>18&&hour<24){
			day="晚上�?";
		}
		request.setAttribute("day", day);
		request.getRequestDispatcher("/WEB-INF/AdminJSP/ARM_Welcome.jsp")
				.forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
