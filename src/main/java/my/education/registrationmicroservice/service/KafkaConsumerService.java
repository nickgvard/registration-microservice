package my.education.registrationmicroservice.service;

import my.education.registrationmicroservice.dto.UserDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KafkaConsumerService {

    void consume(ConsumerRecord<Long, UserDto> consumerRecord);
}
