package com.subscription.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subscription.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

}
