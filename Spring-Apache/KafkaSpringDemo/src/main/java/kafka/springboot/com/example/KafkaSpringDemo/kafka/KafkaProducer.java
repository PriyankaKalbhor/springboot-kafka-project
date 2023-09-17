package kafka.springboot.com.example.KafkaSpringDemo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class KafkaProducer {

    // This Kafka-Producer Produces a String Format
    private KafkaTemplate<String, String> kafkaTemplate;
    private final String topic = "javaguides"; // Define your topic here

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){

        log.info("Message sent: {}",message);
        kafkaTemplate.send(topic, message);
    }
}
