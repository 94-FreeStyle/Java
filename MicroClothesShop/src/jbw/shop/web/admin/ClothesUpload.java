package jbw.shop.web.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.Admin;
import jbw.shop.domain.AllDomain;
import jbw.shop.domain.Clothes;
import jbw.shop.domain.RuKuRecord;
import jbw.shop.utils.ByteID;
import jbw.shop.utils.MapBeanMapping;

public class ClothesUpload extends HttpServlet {

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
		ExecuteSQL esql = new ExecuteSQL();
		Clothes cloth = MapBeanMapping.toBean(request.getParameterMap(),
				Clothes.class);
		String filename = AllDomain.imgname;
		String cid = ByteID.uuid();
		cloth.setC_id(cid);
		cloth.setC_image("/MicroClothesShop/clothes_img/" + filename);
		cloth.setC_sellednum(0);
		try {
			esql.addClothes(cloth);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RuKuRecord rkr = new RuKuRecord();
		String aname = (String) request.getSession().getAttribute("adminn");
		Admin admin = esql.queryAdminByName(aname);
		rkr.setA_id(admin.getA_id());
		rkr.setC_id(cid);
		rkr.setR_date(new Date());
		rkr.setR_id(ByteID.uuid());
		rkr.setR_num(cloth.getC_surplusnum());
		esql.addRuKuRecord(rkr);
		response.getWriter()
				.write("<p style=\"margin-left:600px;margin-top:200px;font-size:22px;color:#ff1111 \">上传成功�?</p>");
	}
}
