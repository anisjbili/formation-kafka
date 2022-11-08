package fr.sfeir.springbootkafka.controller;

import fr.sfeir.springbootkafka.kafka.KafkaJsonProducer;
import fr.sfeir.springbootkafka.kafka.KafkaProducer;
import fr.sfeir.springbootkafka.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/kafka")
public class KafkaController {

    private KafkaProducer kafkaProducer;
    private KafkaJsonProducer kafkaJsonProducer;

    public KafkaController(KafkaProducer kafkaProducer, KafkaJsonProducer kafkaJsonProducer) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaJsonProducer = kafkaJsonProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishJsonMessage(@RequestBody User user) {
        kafkaJsonProducer.sendMessage(user);
        return ResponseEntity.ok("Message sent to the topic");
    }
}
