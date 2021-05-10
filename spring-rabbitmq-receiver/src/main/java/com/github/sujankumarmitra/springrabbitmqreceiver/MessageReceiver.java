package com.github.sujankumarmitra.springrabbitmqreceiver;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class MessageReceiver {

    private ObjectMapper mapper;

    @RabbitListener(queues = "messages")
    public void onMessage(String msg) throws Throwable {
        Message message = mapper.readValue(msg, Message.class);
        log.info("Message Received {}", message);
    }
}
