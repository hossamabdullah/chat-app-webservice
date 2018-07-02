/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.utility;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.mail.*;
import javax.mail.internet.*;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author Hossam Abdallah
 */
public class MainUtility {
    
    public static String encrypt(String password) {
    Base64 codec = new Base64();
    byte[] temp;
    String encodedPassword = null;
    temp = codec.encode(password.getBytes());
    encodedPassword = new String(temp);
    return encodedPassword;
}
     public static String decrypt(String encodedPassword) {
    Base64 codec = new Base64();    
    byte[] temp;
    String decodedPassword;
    temp = codec.decode(encodedPassword.getBytes());
    decodedPassword = new String(temp);
    return decodedPassword;
}
     
    public static void sendMessage(String messageSubject,String messageBody,String targetEmail){
        final String username = "hossamabdalh@gmail.com";
        final String password = "lcgsfidkwdvowytt";
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                }
          });

        try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("hossamabdalh@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(targetEmail));
                message.setSubject(messageSubject);
                message.setText(messageBody);

                Transport.send(message);

                System.out.println("Done");

        } catch (MessagingException e) {
                throw new RuntimeException(e);
        }
    }
}
