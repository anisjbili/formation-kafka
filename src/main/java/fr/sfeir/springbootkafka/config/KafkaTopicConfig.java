package fr.sfeir.springbootkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic sfeirTopic() {
        return TopicBuilder.name("Sfeir").build();
    }

    @Bean
    public NewTopic sfeirJsonTopic() {
        return TopicBuilder.name("SfeirJson").build();
    }
}
