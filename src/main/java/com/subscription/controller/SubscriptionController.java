package com.subscription.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subscription.model.Subscription;
import com.subscription.service.SubscriptionServiceImpl;

@RestController
public class SubscriptionController {
	
	private SubscriptionServiceImpl service;

	@Autowired
	public SubscriptionController(SubscriptionServiceImpl service) {
		this.service = service;
	}
	
	@GetMapping("/subscriptions")
	public List<Subscription> getAllSubscriptions(){
		List<Subscription> subscriptions = service.getAllSubscriptions();
		return subscriptions;
	}
	
	

}
