package org.formation.service;

import java.util.logging.Logger;

import org.formation.GreetingsStream;
import org.formation.model.Greetings;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;


@Service
public class GreetingsService {
    private final GreetingsStream greetingsStreams;

    Logger log = Logger.getLogger(GreetingsService.class.getName());
    
    public GreetingsService(GreetingsStream greetingsStreams) {
        this.greetingsStreams = greetingsStreams;
    }

    public void sendGreeting(final Greetings greetings) {
        log.info("Sending greetings {}" + greetings);

        MessageChannel messageChannel = greetingsStreams.outboundGreetings();
        messageChannel.send(MessageBuilder
                .withPayload(greetings)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
}
