package jbw.shop.web.user;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.User;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadUserTou extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// commons-fileupload的上�?
		// 1.创建工具
		FileItemFactory factory = new DiskFileItemFactory();

		// 2.创建解析器对�?
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setFileSizeMax(80 * 1024);// 设置单个上传的文件上限为80KB

		// 3.解析request得到List<FileItem>
		List<FileItem> fileItemList = null;
		try {
			fileItemList = sfu.parseRequest(request);
		} catch (FileUploadException e) {
			// 如果出现这个异步，说明单个文件超出了80KB
			// error("上传的文件超出了80KB", request, response);
			response.getWriter().write("上传的文件超出了80KB");
			e.printStackTrace();
			return;
		}
		// 获取文件�?
		FileItem fileItem = fileItemList.get(0);
		String filename = fileItem.getName();
		// 截取文件名，因为部分浏览器上传的绝对路径
		int index = filename.lastIndexOf("\\");
		if (index != -1) {
			filename = filename.substring(index + 1);
		}

		// 校验文件名称的扩展名
		if (!(filename.toLowerCase().endsWith(".jpg") || filename.toLowerCase()
				.endsWith(".png"))) { //
			// error("上传的图片扩展名必须是JPG", request, response);
			response.getWriter().write("上传的图片扩展名必须是JPG或PNG");
			return;
		}

		// 保存上传的图片，把图片new成图片对象：Image、Icon、ImageIcon、BufferedImage、ImageIO
		// 保存图片�? 1. 获取真实路径

		String savepath = this.getServletContext().getRealPath("/user_img");

		// 2. 创建目标文件
		File destFile = new File(savepath, filename);

		// 校验图片的尺�?

		// 1. 使用文件路径创建ImageIcon
		ImageIcon icon = new ImageIcon(destFile.getAbsolutePath());
		// 2. 通过ImageIcon得到Image对象
		Image image = icon.getImage();
		// 3. 获取宽高来进行校�?

		if (image.getWidth(null) > 350 || image.getHeight(null) > 350) {
			response.getWriter().write("您上传的图片尺寸超出�?350*350�?");
			destFile.delete();// 删除图片
			return;
		}

		// 保存文件
		try {
			fileItem.write(destFile);// 它会把临时文件重定向到指定的路径，再删除临时文件
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		String dbpath = "/MicroClothesShop/user_img/" + filename;
		String name = (String) request.getSession().getAttribute("userss");

		ExecuteSQL esql = new ExecuteSQL();
		esql.updateUserImg(dbpath, name);
		User user = esql.queryUserByName(name);
		request.setAttribute("user", user);
		try {
			request.setAttribute("topu", esql.getTopUsers());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/UserJSP/UserTemplate.jsp")
				.forward(request, response);

	}

}