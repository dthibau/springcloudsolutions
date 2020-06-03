package org.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members/discovery")
public class DiscoveryController {

	@Autowired
	DiscoveryClient discoveryClient;
	
	@GetMapping
	public Object getInstance(@RequestParam String serviceName) {
		return discoveryClient.getInstances(serviceName);
	}
}
