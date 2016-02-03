package org.parsisys.tehranuniversity.library.util.mail;
import com.sun.mail.smtp.SMTPSSLTransport;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
    
	private String from;
	private String to;
	private String subject;
	private String text;
	private String host = "194.225.0.10";
	private String userid ;
	private String password ;

	public SendMail(String from, String to, String subject, String text,String userid,String password) {
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.text = text;
		this.userid=userid;
		this.password=password;
	}
        class MailAuthenticator extends Authenticator {
            @Override
                  protected PasswordAuthentication getPasswordAuthentication() {
                     return  new PasswordAuthentication(userid,password);
                   }
        }

	public void send() {
		
//		try {
//		   Authenticator auth = new MailAuthenticator();
//			Properties props = System.getProperties();
//			props.put("mail.smtp.starttls.enable", "true");
//			props.put("mail.smtp.host", host);
//			props.setProperty("mail.transport.protocol", "smtps");
//			props.put("mail.smtp.user", userid);
//			props.put("mail.smtp.password", password);
//			props.put("mail.smtp.port", "587");
//		    props.put("mail.smtp.ssl.trust", "*");
//			props.put("mail.smtps.auth", "true");
//			Session session = Session.getDefaultInstance(props, auth);
//			MimeMessage message = new MimeMessage(session);
//			InternetAddress fromAddress = null;
//			InternetAddress toAddress = null;
//
//			try {
//				fromAddress = new InternetAddress(from);
//				toAddress = new InternetAddress(to);
//			} catch (AddressException e) {
//
//				e.printStackTrace();
//			}
//			message.setFrom(fromAddress);
//			message.setRecipient(RecipientType.TO, toAddress);
//			message.setSubject(subject);
//			message.setText(text);
//
////			 SMTPSSLTransport transport
////			 =(SMTPSSLTransport)session.getTransport("smtps");
//
//			//Transport transport = session.getTransport("smtps");
////			transport.connect(host, userid, password);
////			transport.sendMessage(message, message.getAllRecipients());
////			transport.close();
//                    
//		    Transport.send(message);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
            
            Authenticator auth = new MailAuthenticator();
	  Properties props = new Properties();
	  props.put("mail.smtp.host", host);
	  props.put("mail.smtp.port", "25");
	  props.put("mail.smtp.starttls.enable", "true");
	  props.put("mail.smtp.auth", "true");
	  props.put("mail.smtp.ssl.trust", "*");
	 
	  Session session = Session.getInstance(props, auth);
	 
	  try {
	 
	    Message message = new MimeMessage(session);
	    message.setFrom(new InternetAddress(from));
	    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
	    message.setSubject(subject);
	    message.setText(text);
	 
	    Transport.send(message);
	 
	    
	  } catch (MessagingException e) {
	    e.printStackTrace();
	  }
	}
            

}
