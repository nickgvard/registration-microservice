package my.education.registrationmicroservice.service;

import my.education.registrationmicroservice.dto.UserRegistrationDto;

public interface EmailService {

    void sendEmail(UserRegistrationDto userRegistrationDto);
}
