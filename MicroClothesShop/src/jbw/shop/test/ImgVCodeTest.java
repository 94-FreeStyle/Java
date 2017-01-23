package jbw.shop.test;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jbw.shop.utils.ByteID;
import jbw.shop.utils.ImageVCode;
import jbw.shop.utils.MD5PW;

import org.junit.Test;

public class ImgVCodeTest {
	ImageVCode code = new ImageVCode();

	@Test
	public void test1() throws FileNotFoundException, IOException {
		BufferedImage bm = code.getImg();
		code.saveImage(bm, new FileOutputStream("f:\\1.jpg"));
	}

	@Test
	public void test2() {
		System.out.println(ImageVCode.value);
	}

	@Test
	public void test3() {
		System.out.println(MD5PW.strToMD5("jbw994730"));
	}

	@Test
	public void test4() {
		for (int i = 0; i < 5; i++) {
			System.out.println(ByteID.uuid());
		}
	}

	@Test
	public void test5() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 13270225);
		map.put("name", "贾博�?");
		map.put("age", 21);
		// User user=MapBeanMapping.toBean(map, User.class);
		// System.out.println(user);
	}

	@Test
	public void test6() {

		System.out.println(MD5PW.strToMD5("jbw994730"));
	}
}
