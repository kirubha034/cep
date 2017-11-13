package com.cisco.cep.Test;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendFileEmail {
	
	public static void sendEmailReport(){
	final String username = "kirubha.r@ariveguru.com"; //change to your Gmail username
    final String password = "9489044080"; //change to your Gmail password
    final String from = "kirubha.r@ariveguru.com"; //change to from email address
    //final String to = "kirubha034@gmail.com"; //change to to email address
    final String[] to = {"kirubha034@gmail.com","kirubha.r@ariveguru.com"}; 
    //final String cc = "test.cc.email@helloselenium.com"; //change to cc email address
    //final String bcc = "test.bcc.email@helloselenium.com"; //change to bcc email address
    final String subject = "Test Email from Hello Selenium"; //change to your subject
    final String msg = "Test Email from Hello Selenium to learn the automation of email message sending using Java Mail API from Gmail."; //change to your message
 
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.socketFactory.port", "465");
	props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.port", "465");
 
    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
 
    try {
    	
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        for(int i=0;i<to.length;i++){
        	System.out.println(to[i]);
        	message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to[i]));	
        
        //below code only requires if your want cc email address
       // message.setRecipients(Message.RecipientType.CC,
          //      InternetAddress.parse(cc));
        //below code only requires if your want bcc email address
       // message.setRecipients(Message.RecipientType.BCC,
            //    InternetAddress.parse(bcc));
        message.setSubject(subject);
        message.setText(msg);
 
        MimeBodyPart messageBodyPart = new MimeBodyPart();
 
        Multipart multipart = new MimeMultipart();
 
        messageBodyPart = new MimeBodyPart();
        //String file1 = "drive:\\folder1\\folder2\\file.txt"; //change to your attachment filepath
        String file1="C:\\Users\\kirajama\\Desktop\\WS-L-Eclipse\\CEP\\test-output";
        String fileName1 = "\\emailable-report.html"; //change to your attachment filename
        //String fileName1=reportFileName;
        DataSource source1 = new FileDataSource(file1+fileName1);
        messageBodyPart.setDataHandler(new DataHandler(source1));
        messageBodyPart.setFileName(fileName1);
        multipart.addBodyPart(messageBodyPart);
 
        message.setContent(multipart);
 
        System.out.println("Sending");
 
        Transport.send(message);
    	
        System.out.println("Done");
    	}
    } catch (MessagingException e) {
        e.printStackTrace();
    }
  }
}

