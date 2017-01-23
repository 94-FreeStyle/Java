package jbw.shop.web.user;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jbw.shop.utils.ImageVCode;

public class VCode extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ImageVCode vcode = new ImageVCode();
		BufferedImage img = vcode.getImg();
		vcode.saveImage(img, response.getOutputStream());
	}
}
