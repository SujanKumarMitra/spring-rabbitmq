package com.github.sujankumarmitra.springrabbitmqsender;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE;

@RestController
@AllArgsConstructor
public class MessageController {

    private MessageSender sender;

    @PostMapping("/send")
    public Mono<HttpStatus> send(@RequestBody Message message) {
        try {
            sender.send(message);
            return Mono.just(OK);
        } catch (Throwable th) {
            th.printStackTrace();
            return Mono.just(SERVICE_UNAVAILABLE);
        }
    }
}
