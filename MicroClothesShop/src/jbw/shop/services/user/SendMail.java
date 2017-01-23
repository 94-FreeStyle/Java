package jbw.shop.services.user;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {
	String protocol = "smtp";
	String from = "jbw.ghost@foxmail.com";
	String subject = "微服网店找回密码";

	String body = "<a href=\"http://localhost:8080/MicroClothesShop/servlet/CallBackPWOK\">Click for CallBack Password!</br></br><img src=\"cid:my_baidu_jpg\" width=\"100px\" height=\"140px\"></a>";

	public void send(String mail) throws Exception {
		String server = "smtp.foxmail.com";
		String user = "jbw.ghost";
		String password = "jbw923909";
		String to = mail;
		SendMail sender = new SendMail();
		Session session = sender.createSession();
		MimeMessage message = sender.createMessage(session, to);

		// 获得Transport对象，并链接邮件服务器发送邮�?
		Transport transport = session.getTransport();
		transport.connect(server, user, password);
		transport.sendMessage(message,
				message.getRecipients(Message.RecipientType.TO));
		transport.close();
	}

	public Session createSession() {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", protocol);
		props.setProperty("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true);
		return session;
	}

	public MimeMessage createMessage(Session session, String to)
			throws Exception {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
		message.setSubject(subject);
		MimeMultipart mutipart = new MimeMultipart("related");
		MimeBodyPart htmlBodyPart = new MimeBodyPart();
		htmlBodyPart.setContent(body, "text/html;chartset=utf-8");
		mutipart.addBodyPart(htmlBodyPart);

		MimeBodyPart gifBodyPart = new MimeBodyPart();
		FileDataSource fds = new FileDataSource("e:\\Picture\\person\\1.jpg");
		gifBodyPart.setDataHandler(new DataHandler(fds));
		gifBodyPart.setContentID("my_baidu_jpg");
		mutipart.addBodyPart(gifBodyPart);
		message.setContent(mutipart);
		message.saveChanges();
		return message;
	}
}
