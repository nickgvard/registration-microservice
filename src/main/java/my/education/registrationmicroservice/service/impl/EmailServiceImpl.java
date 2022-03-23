package my.education.registrationmicroservice.service.impl;

import lombok.RequiredArgsConstructor;
import my.education.registrationmicroservice.dto.UserDto;
import my.education.registrationmicroservice.service.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Override
    public void sendEmail(UserDto userDto) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(userDto.getEmail());
        message.setSubject("New user registration");
        message.setText("Hi, " + userDto.getName() + "! You are registered.");

        mailSender.send(message);
    }
}
