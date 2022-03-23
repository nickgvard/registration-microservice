package my.education.registrationmicroservice.service;

import my.education.registrationmicroservice.dto.UserDto;

public interface EmailService {

    void sendEmail(UserDto userDto);
}
