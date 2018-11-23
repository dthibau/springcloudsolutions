package org.formation.service;

import java.util.logging.Logger;

import org.formation.GreetingsStream;
import org.formation.model.Greetings;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class GreetingsListener {
	Logger log = Logger.getLogger(GreetingsListener.class.getSimpleName());
	
    @StreamListener(GreetingsStream.INPUT)
    public void handleGreetings(@Payload Greetings greetings) {
        log.info("Received greetings: {}" + greetings);
    }
}
