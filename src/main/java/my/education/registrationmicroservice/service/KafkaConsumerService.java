package my.education.registrationmicroservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import my.education.registrationmicroservice.dto.UserRegistrationDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KafkaConsumerService {

    void consume(ConsumerRecord<Long, String> consumerRecord) throws JsonProcessingException;
}
