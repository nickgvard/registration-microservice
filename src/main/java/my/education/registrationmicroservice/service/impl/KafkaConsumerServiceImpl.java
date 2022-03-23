package my.education.registrationmicroservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.education.registrationmicroservice.dto.UserDto;
import my.education.registrationmicroservice.service.KafkaConsumerService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private final EmailServiceImpl emailServiceImpl;

    @KafkaListener(topics = "${kafka.registration.topic.name}")
    @Override
    public void consume(ConsumerRecord<Long, UserDto> consumerRecord) {
        emailServiceImpl.sendEmail(consumerRecord.value());
        log.info("[Consume message by user: {} with offset={}]", consumerRecord.value(), consumerRecord.offset());
    }
}
