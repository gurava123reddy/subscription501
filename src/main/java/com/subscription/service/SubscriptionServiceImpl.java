package com.subscription.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subscription.model.Subscription;
import com.subscription.repository.SubscriptionRepository;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	
	@Autowired
	private SubscriptionRepository repository;

	@Override
	public List<Subscription> getAllSubscriptions() {
		return repository.findAll();
	}

	
	
	

}
