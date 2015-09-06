package com.cvg.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

	int itemId;
	int upc;
	String itemName;
	String company;
	int dateEntered;
	int expirationDate;
	int quantity;
	
	public Item(){
		
	}
	
	public Item(int itemId){
		this.itemId = itemId;
	}
	
	public Item(@JsonProperty("itemId")int itemId, @JsonProperty("upc")int upc, @JsonProperty("itemName")String itemName, @JsonProperty("company")String company, @JsonProperty("dateEntered")int dateEntered, @JsonProperty("expirationDate")int expirationDate,
			@JsonProperty("quantity")int quantity) {
		super();
		this.upc = upc;
		this.itemName = itemName;
		this.company = company;
		this.dateEntered = dateEntered;
		this.expirationDate = expirationDate;
		this.quantity = quantity;
	}
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getUpc() {
		return upc;
	}
	public void setUpc(int upc) {
		this.upc = upc;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getDateEntered() {
		return dateEntered;
	}
	public void setDateEntered(int dateEntered) {
		this.dateEntered = dateEntered;
	}
	public int getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(int expirationDate) {
		this.expirationDate = expirationDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}


