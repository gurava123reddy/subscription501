package com.subscription.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Vendor {
	
	@Id
	private Long id;
	private String accountNumber;
	private String isoCountryCode;
	private String currencyCode;
	private String contactEmail;
	private String contactNumber;
	private String contactName;
	private String extIdentifier;
	private String sourceName;
	private Date creationDate;
	private Date updateDate;
	private String denominator;
	private String name;
	private String unit;
	private String value;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIsoCountryCode() {
		return isoCountryCode;
	}
	public void setIsoCountryCode(String isoCountryCode) {
		this.isoCountryCode = isoCountryCode;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getExtIdentifier() {
		return extIdentifier;
	}
	public void setExtIdentifier(String extIdentifier) {
		this.extIdentifier = extIdentifier;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
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
	public String getDenominator() {
		return denominator;
	}
	public void setDenominator(String denominator) {
		this.denominator = denominator;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Vendor [id=" + id + ", accountNumber=" + accountNumber + ", isoCountryCode=" + isoCountryCode
				+ ", currencyCode=" + currencyCode + ", contactEmail=" + contactEmail + ", contactNumber="
				+ contactNumber + ", contactName=" + contactName + ", extIdentifier=" + extIdentifier + ", sourceName="
				+ sourceName + ", creationDate=" + creationDate + ", updateDate=" + updateDate + ", denominator="
				+ denominator + ", name=" + name + ", unit=" + unit + ", value=" + value + "]";
	}
	
	
	
	
	
	

}
