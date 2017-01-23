package jbw.shop.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

import jbw.shop.services.user.SendMail;

public class Sendmail {
	@Test
	public void test() {
		SendMail send = new SendMail();
		try {
			send.send("jbw.ghost@outlook.com");
			System.out.println("OK!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test2() throws AddressException, MessagingException {
		String from = "jbw.ghost@foxmail.com";
		String to = "jbw.ghost@outlook.com";
		String subject = "test";
		String body = "It's my java mail demo!!!";
		// 创建Session实例对象
		Session session = Session.getDefaultInstance(new Properties());
		// 创建MimeMessage实例对象
		MimeMessage msg = new MimeMessage(session);
		// 设置发件�?
		msg.setFrom(new InternetAddress(from));
		// 设置收件�?
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		// 设置发�?�日�?
		msg.setSentDate(new Date());
		// 设置邮件主题
		msg.setSubject(subject);
		// 设置纯文本内容的邮件正文
		msg.setText(body);
		// 保存并生成最终邮�?
		msg.saveChanges();

		// 把MimeMessage对下个中的内容写入到文件�?
		try {
			msg.writeTo(new FileOutputStream("f:\\test.eml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("已完成所有工�?!");
	}
}
