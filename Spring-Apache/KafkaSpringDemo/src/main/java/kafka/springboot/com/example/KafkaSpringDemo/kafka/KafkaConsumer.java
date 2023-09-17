package kafka.springboot.com.example.KafkaSpringDemo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    // The consumer consume the messages from the kafka broker or kafka server
    // Here we listen the messages from the kafka broker/server

    // This Kafka-Consumer Listen a String Format

    @KafkaListener(topics = "javaguides", groupId = "myGroup")
    public void consume(String message){
        log.info("Message received : {}", message);

    }
}
