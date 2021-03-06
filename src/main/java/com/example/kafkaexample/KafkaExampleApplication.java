package com.example.kafkaexample;

import com.example.kafkaexample.dto.UserDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;


@EnableKafka
@SpringBootApplication
public class KafkaExampleApplication {

    @KafkaListener(topics="msg")
    public void orderListener(ConsumerRecord<Long, UserDto> record){
        System.out.println(record.partition());
        System.out.println(record.key());
        System.out.println(record.value());
    }

    public static void main(String[] args) {

        SpringApplication.run(KafkaExampleApplication.class, args);
    }

}
