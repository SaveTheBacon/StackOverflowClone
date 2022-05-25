package com.example.assignments.service;



import com.example.assignments.model.User;
import com.example.assignments.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Service
public class UserService {

    @Autowired
    IUserRepository iUserRepository;

    public List<User> getAllUsers(){
        return (List<User>) iUserRepository.findAll();
    }

    public User getUser(Integer ID){
        Optional<User> user = iUserRepository.findById(ID);
        return user.orElse(null);
    }

    public String deleteUser(Integer ID){
        try{
            iUserRepository.delete(this.getUser(ID));
            return "Delete successful";
        }
        catch (Exception e){
            return "Deletion failed";
        }
    }

    public User saveUser(User user){
        return iUserRepository.save(user);
    }

    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("bogdan.stefan.bs0412@gmail.com");
        mailSender.setPassword("zfkaaowirpjxzmpn");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    public void sendSimpleMessage(String to, String subject, String text) {

        Thread thread = new Thread(){
            public void run(){
                JavaMailSender emailSender = getJavaMailSender();
                SimpleMailMessage message = new SimpleMailMessage();
                message.setFrom("noreply@baeldung.com");
                message.setTo(to);
                message.setSubject(subject);
                message.setText(text);
                emailSender.send(message);
            }
        };
        thread.start();

    }

    public User banUser(Integer id){
        User initial = getUser(id);
        sendSimpleMessage(initial.getEmail(), "Ban notice", "You were banned from using the site for inappropriate behaviour.");
        initial.setBanned(true);
        return iUserRepository.save(initial);
    }

    public User updateUser(User user){
        User initialUser = user;
        return iUserRepository.save(initialUser);
    }


}
