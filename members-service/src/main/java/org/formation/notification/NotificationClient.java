package org.formation.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class NotificationClient {

	
	@Autowired
	RestTemplateBuilder restBuilder;
	
	private static String NOTIFICATION_SERVICE="http://notification-service.default.svc.cluster.local:9090";

	@HystrixCommand(fallbackMethod = "envoiCourrierFallBack",
			commandProperties = { @HystrixProperty(
			name = "execution.isolation.thread.timeoutInMilliseconds",
			value = "1000") })
	public String envoiCourrier(Courriel courriel) {
		RestTemplate restTemplate = restBuilder.rootUri(NOTIFICATION_SERVICE).build();

		
		return restTemplate.postForEntity("/sendSimple", courriel, String.class).getBody();
	}
	
	public String envoiCourrierFallBack(Courriel courriel) {
		
		System.out.println("FALLBACK "+courriel.getTo());
		return "NOT SEND YET";
	}
}
