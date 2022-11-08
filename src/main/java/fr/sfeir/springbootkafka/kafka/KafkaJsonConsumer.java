package fr.sfeir.springbootkafka.kafka;

import fr.sfeir.springbootkafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonConsumer.class);

    @KafkaListener(topics = "SfeirJson", groupId = "SfeirGroup")
    private void consume(User user) {
        LOGGER.info(String.format("Message recieved %s", user.toString()));
    }
}
