package com.github.sujankumarmitra.springrabbitmqsender;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class MessageSender {

    private ObjectMapper objectMapper;
    private RabbitTemplate rabbitTemplate;

    public void send(Message message) throws Throwable {
        String json = objectMapper.writeValueAsString(message);
        rabbitTemplate.convertAndSend("", "messages", json);
    }
}
