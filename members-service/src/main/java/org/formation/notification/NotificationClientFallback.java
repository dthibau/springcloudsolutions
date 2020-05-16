package org.formation.notification;

import org.springframework.stereotype.Service;


@Service
public class NotificationClientFallback implements NotificationClient {

	@Override
	public String envoiCourrier(Courriel courriel) {
		
		System.out.println("FALLBACK !! Pretending all is OK ");
		return "OK";
	}

}
