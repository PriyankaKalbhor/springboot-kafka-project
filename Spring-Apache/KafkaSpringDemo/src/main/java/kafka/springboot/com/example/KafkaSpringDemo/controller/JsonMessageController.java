package kafka.springboot.com.example.KafkaSpringDemo.controller;

import kafka.springboot.com.example.KafkaSpringDemo.kafka.JsonKafkaProducer;
import kafka.springboot.com.example.KafkaSpringDemo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private final JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    // http://localhost:9093/api/v1/kafka/publish
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody  User user){

        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json Message sent to kafka topic");
    }
}
