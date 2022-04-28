package com.example.demo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;





@Table
@Entity

public class Product {
	
	
	@Column(name="id")
	//TODO uztaisīt unikālu id piešķiršanu no DB puses
	private int id;
	
	@NotNull
	@Size(min=3, max=30)
	@Pattern(regexp="[A-Z]{1}[a-z]+")
	@Column(name="title")
	private String title;
	
	@NotNull
	@Size(min=3, max=50)
	@Pattern(regexp="[A-Z]{1}[a-z]+")
	@Column(name="description")
	private String description;
	
	@Min(0)
	@Max(10000)
	@Column(name="quantity")
	private int quantity;
	
	
	@Min(0)
	@Max(100)
	@Column(name="price")
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
 

	
	









