package kafka.springboot.com.example.KafkaSpringDemo.kafka;

import kafka.springboot.com.example.KafkaSpringDemo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonKafkaConsumer {

    @KafkaListener(topics = "javaguides_json", groupId = "myGroup")
    public void consume(User user){
        log.info("Json Message received : {}", user.toString());
    }
}
