package com.example.demo.model;

public class Product {
	private int id;
	private String title;
	private String description;
	private int quantity;
	private float price;
	
	private static int counter = 0;

//----------------Getters --------------------
	
	public String getTitle() {
		return title;
	}
	public int getId() {
		return id;
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
	public void setId() {
		this.id = counter;
		counter++;
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
	setId();
	this.title = title;
	this.description = description;
	this.quantity = quantity;
	this.price = price;
}
 
}
 

	
	









