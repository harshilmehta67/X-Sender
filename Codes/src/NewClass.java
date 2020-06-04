/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;  
/**
 *
 * @author MANAV PATEL
 */
public class NewClass {
    boolean sendMail(boolean check, String email, String username) {
        final String to = email;
        final String from = "harshilmehta67@gmail.com";
        final String passwordMail = "Hpmehta67" ;
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");
     try{
     Session session = Session.getDefaultInstance(props, 
                          new Authenticator(){
                             @Override
                             protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, passwordMail);
                             }});

   // -- Create a new message --
     Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(from));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject("Welcome to |X-$ender|");
            msg.setText("Hey!\n"
                    + "    " + username + ", Thanks for signing up in X-$ender\n"
                    + "We would thank you for using these app in future too. \n"
                    + "Thanks, team X-$ender.");

            // Send message  
            Transport.send(msg);
            check = true;
            System.out.println("message sent successfully....");

        } catch (MessagingException mex) {
            mex.printStackTrace();
            check = false;
        }
        return check;
    }
    public static void main(String[] args) {
        boolean c = sendMail(true,"harshilmehta@gmail.com","abcde");
    }
    
}
