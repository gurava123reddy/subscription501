package com.subscription.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Subscription {
	
	@Id
	private long id;
	private Date creationDate;
	private Date updateDate;
	private String subscriptionId;
	private String extIdentifier;
	private String billingFrequency;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	private Account account;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subscription_id")
	private Vendor vendor;
	
	private String sourceName;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "subscription_id")
	private List<Order> orders;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "subs_id")
	private List<SubscriptionItem> subscriptionItems;
	
	
	private List<SubscriptionAttribute> subscriptionAttributes;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public String getExtIdentifier() {
		return extIdentifier;
	}
	public void setExtIdentifier(String extIdentifier) {
		this.extIdentifier = extIdentifier;
	}
	public String getBillingFrequency() {
		return billingFrequency;
	}
	public void setBillingFrequency(String billingFrequency) {
		this.billingFrequency = billingFrequency;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public List<SubscriptionItem> getSubscriptionItems() {
		return subscriptionItems;
	}
	public void setSubscriptionItems(List<SubscriptionItem> subscriptionItems) {
		this.subscriptionItems = subscriptionItems;
	}
	public List<SubscriptionAttribute> getSubscriptionAttributes() {
		return subscriptionAttributes;
	}
	public void setSubscriptionAttributes(List<SubscriptionAttribute> subscriptionAttributes) {
		this.subscriptionAttributes = subscriptionAttributes;
	}
}
