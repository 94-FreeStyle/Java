package jbw.shop.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class ImageVCode {
	private int w = 75;
	private int h = 40;
	private Random random = new Random();
	public static String value = "";
	// 生成随机字体
	private Font getFont() {
		String[] fontName = { "宋体", "楷体", "微软雅黑", "黑体", "粗体" };
		int[] fontStyle = { 1, 2, 3, 4 };
		int[] fontSize = { 24, 25, 26, 27 ,28};
		int nameFlag = random.nextInt(fontName.length);
		int styleFlag = random.nextInt(fontStyle.length);
		int sizeFlag = random.nextInt(fontSize.length);
		Font font = new Font(fontName[nameFlag], fontStyle[styleFlag],
				fontSize[sizeFlag]);
		return font;
	}

	// 生成随机颜色
	private Color getColor() {
		int r = random.nextInt(255);
		int g = random.nextInt(255);
		int b = random.nextInt(255);
		Color color = new Color(r, g, b);
		return color;
	}

	// 生成随机干扰�?
	private void getLine(BufferedImage img) {
		Graphics2D g = (Graphics2D) img.getGraphics();
		g.setColor(Color.BLACK);
		g.setStroke(new BasicStroke(1.5f));
		for (int i = 0; i < 4; i++) {
			int x1 = random.nextInt(w);
			int x2 = random.nextInt(w);
			int y1 = random.nextInt(h);
			int y2 = random.nextInt(h);
			g.drawLine(x1, y1, x2, y2);
		}
	}

	// 生成随机字符
	private String getChar() {
		String strs = "abcdefghigklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int flag = random.nextInt(strs.length());
		String str = strs.charAt(flag) + "";
		return str;
	}

	// 生成�?原始图片
	private BufferedImage getImage() {
		BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		img.getGraphics().setColor(new Color(240, 240, 240));
		img.getGraphics().fillRect(0, 0, w, h);
		return img;
	}

	// 返回�?终图�?
	public BufferedImage getImg() {
		value="";
		BufferedImage img = this.getImage();
		// �?始绘�?,考虑字体，大小，位置，干扰线，内容，颜色
		Graphics g = img.getGraphics();
		for (int i = 0; i < 4; i++) {
			g.setColor(this.getColor());
			g.setFont(this.getFont());
			String val = this.getChar();
			g.drawString(val, w / 4 * i, h - 12);
			value = value+val;
		}
		System.out.println(value);
		this.getLine(img);
		return img;
	}
	//保存图片
	public void saveImage(BufferedImage img,OutputStream os) throws IOException{
		ImageIO.write(img, "JPEG", os);
	}
}
