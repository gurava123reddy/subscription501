package com.subscription.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class SubscriptionAttribute {
	
	@Id
	private Long id;
	private String key;
	private String value;
	
	@ManyToOne
	@JoinColumn(name = "subs_id")
	private Subscription subscription;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Subscription getSubscription() {
		return subscription;
	}
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	@Override
	public String toString() {
		return "SubscriptionAttribute [id=" + id + ", key=" + key + ", value=" + value + ", subscription="
				+ subscription + "]";
	}
	

}
