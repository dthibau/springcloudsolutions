package org.formation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/members")
public class DiscoveryController {

	@Autowired
	DiscoveryClient discoveryClient;
	
	@Autowired
	RestTemplateBuilder restBuilder;
	
	private static String NOTIFICATION_SERVICE="http://notification-service.default.svc.cluster.local:9090";
	
	@GetMapping
	@RequestMapping("/discovery")
	public List<ServiceInstance> getInstance(@RequestParam String serviceName) {
		return discoveryClient.getInstances(serviceName);
	}
	
	@GetMapping
	@RequestMapping("/rest")
	public ResponseEntity<String> callNotification() {
		RestTemplate restTemplate = restBuilder.rootUri(NOTIFICATION_SERVICE).build();
		Map<String,String> map = new HashMap<>();
		map.put("subject", "Sujet");
		map.put("to", "david.thibau@gmail.com");
		map.put("text", "Un coucou");
		
		return restTemplate.postForEntity("/sendSimple", map, String.class);
	}
}
