package com.paisabazaar.kafkaproducerlayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KafkaProducerLayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerLayerApplication.class, args);
    }

}
