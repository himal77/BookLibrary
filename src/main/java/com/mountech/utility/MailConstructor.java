package com.mountech.utility;

import com.mountech.domain.User;
import org.omg.CORBA.Environment;
import org.omg.CORBA.LocalObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MailConstructor {
     @Autowired
    private Environment env;

     public SimpleMailMessage constructResetTokenEmail(
             String contextPath, Locale locale, String token, User user, String password
     ){
         String url = contextPath = "/newUser?token="+token;
         String message = "\nPlease click on this link to verify yoour email and edit your information. Your password is: \n"+password
         SimpleMailMessage email = new SimpleMailMessage();
         email.setTo(user.getEmail());
         email.setSubject("Mountain library new user");
         email.setText(url+message);
         email.setFrom(env.setProperty("support.email"));
         return email;
     }

}
