package org.formation.client;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

@Service
public class NotificationClientFallback implements NotificationClient {

	protected Logger logger = Logger.getLogger(NotificationClientFallback.class.getName());

	public String sendSimple(Courriel email) {
		logger.info("FALLING BACK");
		return "OK";
	}

}
