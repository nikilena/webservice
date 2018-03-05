package management;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 

public class SendEmail {
 
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
 


	public void generateAndSendEmail(String email, String text) throws AddressException, MessagingException {
 

		System.out.println("\n  ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		mailServerProperties.put("mail.smtp.user","nikilena92@gmail.com"); 
		mailServerProperties.put("mail.smtp.host", "smtp.gmail.com");
		mailServerProperties.put("mail.smtp.EnableSSL.enable","true");
		System.out.println("Mail Server Properties have been setup successfully..");
		
		mailServerProperties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
		mailServerProperties.setProperty("mail.smtp.socketFactory.fallbac k", "false"); 
		mailServerProperties.setProperty("mail.smtp.port", "465"); 
		mailServerProperties.setProperty("mail.smtp.socketFactory.port", "465"); 

		System.out.println("\n\n ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		generateMailMessage.setSubject("Greetings from Notification Web-service..");
		String emailBody = text + "<br><br> Regards, <br>To-Do Admin";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");
 

		System.out.println("\n\n ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
 

		transport.connect("smtp.gmail.com", "nikilena92@gmail.com", "1asdfghjklyxcvb");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
}