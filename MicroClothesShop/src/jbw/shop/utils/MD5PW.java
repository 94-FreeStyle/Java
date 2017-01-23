package jbw.shop.utils;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

public class MD5PW {

	/**
	 * 把字节数组转�?16进位制数
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bytesToHex(byte[] bytes) {
		StringBuffer md5str = new StringBuffer();
		// 把数组每�?字节换成16进制连成md5字符�?
		int digital;
		for (int i = 0; i < bytes.length; i++) {
			digital = bytes[i];
			if (digital < 0) {
				digital += 256;
			}
			if (digital < 16) {
				md5str.append("0");
			}
			md5str.append(Integer.toHexString(digital));
		}
		return md5str.toString().toUpperCase();
	}

	/**
	 * 把字节数组转换成md5
	 * 
	 * @param input
	 * @return
	 */
	public static String bytesToMD5(byte[] input) {
		String md5str = null;
		try {
			// 创建�?个提供信息摘要算法的对象，初始化为md5算法对象
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 计算后获得字节数�?
			byte[] buff = md.digest(input);
			// 把数组每�?字节换成16进制连成md5字符�?
			md5str = bytesToHex(buff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return md5str;
	}

	/**
	 * 把字符串转换成md5
	 * 
	 * @param str
	 * @return
	 */
	public static String strToMD5(String str) {
		byte[] input = str.getBytes();
		return bytesToMD5(input);
	}

	/**
	 * 把文件转成md5字符�?
	 * 
	 * @param file
	 * @return
	 */
	public static String fileToMD5(File file) {
		if (file == null) {
			return null;
		}
		if (file.exists() == false) {
			return null;
		}
		if (file.isFile() == false) {
			return null;
		}
		FileInputStream fis = null;
		try {
			// 创建�?个提供信息摘要算法的对象，初始化为md5算法对象
			MessageDigest md = MessageDigest.getInstance("MD5");
			fis = new FileInputStream(file);
			byte[] buff = new byte[1024];
			int len = 0;
			while (true) {
				len = fis.read(buff, 0, buff.length);
				if (len == -1) {
					break;
				}
				// 每次循环读取�?定的字节都更�?
				md.update(buff, 0, len);
			}
			// 关闭�?
			fis.close();
			// 返回md5字符�?
			return bytesToHex(md.digest());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
