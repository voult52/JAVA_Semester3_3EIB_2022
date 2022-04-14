package com.example.demo.model;

public class Product {
	private String title;
	private String description;
	private int quantity;
	private float price;

//----------------Getters --------------------
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public int getQuantity() {
		return quantity;
	}
	public float getPrice() {
		return price;
	}

	
//----------------Setters --------------------	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	




//---------------- Construcions --------------------	

//Bezargumenta
public Product() {}




//Argumenta
public Product(String title, String description, int quantity, float price) {
	super();
	this.title = title;
	this.description = description;
	this.quantity = quantity;
	this.price = price;
}
 
}
 

	
	









