package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.model.Product;

public interface ICRUDProductService {
	
	//CRUD - create-read-update-delete
	
//--------------create------------------
	
	public abstract void createProduct(Product temp);
	
//--------------read--------------------
	
	//read all
	public abstract ArrayList<Product> readAllProducts();
	
	//read by id
	public abstract Product readById(int id);
	
	
//----------------update---------------
	public abstract boolean updateById(int id, Product temp);
	
//----------------delete----------------
	public abstract void deleteById(int id);
	
	
	
	
	
}
