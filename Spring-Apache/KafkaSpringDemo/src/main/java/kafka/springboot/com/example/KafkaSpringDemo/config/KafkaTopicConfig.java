package kafka.springboot.com.example.KafkaSpringDemo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    // Create bean for kafka topic in kafka cluster
    // This below topic used for String Format
    @Bean
    public NewTopic springBootTopic(){
        return TopicBuilder.name("javaguides")
                .build();
    }

    @Bean
    public NewTopic springBootJsonTopic(){
        return TopicBuilder.name("javaguides_json")
                .build();
    }
}
