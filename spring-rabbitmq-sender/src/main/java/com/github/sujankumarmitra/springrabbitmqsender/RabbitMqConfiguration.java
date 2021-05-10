package com.github.sujankumarmitra.springrabbitmqsender;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

    @Bean
    public Queue messageQueue() {
        return new Queue("messages");
    }

}
