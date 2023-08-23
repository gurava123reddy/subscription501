package com.subscription.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.subscription.model.Subscription;

public interface SubscriptionService{
	
	public List<Subscription> getAllSubscriptions();
	

}
