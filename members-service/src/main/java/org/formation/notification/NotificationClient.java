package org.formation.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationClient {

	
	@Autowired
	RestTemplateBuilder restBuilder;
	
	private static String NOTIFICATION_SERVICE="http://notification-service.default.svc.cluster.local:9090";

	
	public String envoiCourrier(Courriel courriel) {
		RestTemplate restTemplate = restBuilder.rootUri(NOTIFICATION_SERVICE).build();

		
		return restTemplate.postForEntity("/sendSimple", courriel, String.class).getBody();
	}
}
