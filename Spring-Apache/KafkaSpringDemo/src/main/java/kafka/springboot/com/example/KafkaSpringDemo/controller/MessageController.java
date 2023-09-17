package kafka.springboot.com.example.KafkaSpringDemo.controller;

import kafka.springboot.com.example.KafkaSpringDemo.kafka.KafkaProducer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private final KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    // http://localhost:9093/api/v1/kafka/publish?message="hello"

    // Send the String Format Message
   @GetMapping("/publish")
   public ResponseEntity<String> publish(@RequestParam("message") String message){
       // kafkaProducer internally use kafka template to sent message to the kafka topic
        kafkaProducer.sendMessage(message);
        return  ResponseEntity.ok("Message sent to the topic successfully!");
   }

}
