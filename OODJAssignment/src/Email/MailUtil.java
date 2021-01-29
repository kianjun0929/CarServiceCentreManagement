/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import java.util.ArrayList;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
//import javax.mail.Authenticator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
//import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
//import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/**
 *
 * @author kianjun
 */
public class MailUtil {
    public static void sendEmail(String recipient, ArrayList CustomerDetails) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        //AASCKLMalaysia@gmail.com
        String myAccountEmail = "AASCKLMalaysia@gmail.com";
        String password = "kianjun0929";


        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        Message message = prepareMessage(session, myAccountEmail, recipient, CustomerDetails);

        Transport.send(message);
        System.out.println("Email Sent");
    }
    
    public static void sendReceipt(String recipient) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccountEmail = "AASCKLMalaysia@gmail.com";
        String password = "kianjun0929";


        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        Message message = prepareReceipt(session, myAccountEmail, recipient);

        Transport.send(message);
        System.out.println("Email Sent");
    }
    
    private static Message prepareMessage(Session session, String myAccountEmail, String recipient, ArrayList CustomerDetails) {
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Welcome to APU Automotive Service Centre");
            message.setText("Hi " + CustomerDetails.get(2) + ",\nThank you for joining us!\nYour member ID is: " + CustomerDetails.get(0) +" \nYou can use your member ID to make appointment with our technician right now ! \n\nPlease be noted that you can only make one appointment at a time. "+ " \n\n Best Regards, \n APU Automotive Service Center");
            
            return message;
        } catch (Exception ex) {
            Logger.getLogger(MailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private static Message prepareReceipt(Session session, String myAccountEmail, String recipient) {
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("APU Automotive Service Center E-Receipts");
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();
            String file = "receipt.pdf";
            String fileName = "receipt.pdf";
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            return message;
        } catch (Exception ex) {
            Logger.getLogger(MailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
