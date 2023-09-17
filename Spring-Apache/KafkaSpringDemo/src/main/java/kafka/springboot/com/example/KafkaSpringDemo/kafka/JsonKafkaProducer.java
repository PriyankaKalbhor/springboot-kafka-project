package kafka.springboot.com.example.KafkaSpringDemo.kafka;

import kafka.springboot.com.example.KafkaSpringDemo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service // Makes this class as spring-bean
@Slf4j
public class JsonKafkaProducer {

    // Inject Kafka-Template To send Json message to Kafka-Topic
    private final KafkaTemplate<String, User> kafkaTemplate;


    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data){

        // This Json_Producer send json message to javaguides_json topic
        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "javaguides_json")
                .build();

        // Send message using Kafka Template
        log.info("Message send : {} ",data.toString());
        kafkaTemplate.send(message);
    }

}
