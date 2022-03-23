package my.education.registrationmicroservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.education.registrationmicroservice.dto.UserRegistrationDto;
import my.education.registrationmicroservice.service.KafkaConsumerService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private final EmailServiceImpl emailServiceImpl;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "${kafka.registration.topic.name}")
    @Override
    public void consume(ConsumerRecord<Long, String> consumerRecord) {
        String value = consumerRecord.value();
        try {
            UserRegistrationDto userRegistrationDto = objectMapper.readValue(value, UserRegistrationDto.class);
            emailServiceImpl.sendEmail(userRegistrationDto);
            log.info("[Consume message by user: {} with offset={}]", userRegistrationDto, consumerRecord.offset());
        }catch (JsonProcessingException processingException) {
            log.error("[Json processing by user: {} error]", value);
        }
    }
}
