package com.epam.dzerhunou.trackconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@EnableEurekaClient
public class TrackConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrackConsumerApplication.class, args);
    }

}
