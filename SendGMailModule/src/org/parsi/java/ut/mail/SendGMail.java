package org.parsi.java.ut.mail;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendGMail {
	private String from;
	private String to;
	private String subject;
	private String text;
	private String host = "smtp.gmail.com";
	private String userid ;
	private String password ;

	public SendGMail(String from, String to, String subject, String text,String userid,String password) {
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.text = text;
		this.userid=userid;
		this.password=password;
	}

	public void send() {
		
		try {
			Properties props = System.getProperties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.setProperty("mail.transport.protocol", "smtps");
			props.put("mail.smtp.user", userid);
			props.put("mail.smtp.password", password);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtps.auth", "true");
			Session session = Session.getDefaultInstance(props, null);
			MimeMessage message = new MimeMessage(session);
			InternetAddress fromAddress = null;
			InternetAddress toAddress = null;

			try {
				fromAddress = new InternetAddress(from);
				toAddress = new InternetAddress(to);
			} catch (AddressException e) {

				e.printStackTrace();
			}
			message.setFrom(fromAddress);
			message.setRecipient(RecipientType.TO, toAddress);
			message.setSubject(subject);
			message.setText(text);

			// SMTPSSLTransport transport
			// =(SMTPSSLTransport)session.getTransport("smtps");

			Transport transport = session.getTransport("smtps");
			transport.connect(host, userid, password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
