package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.services.ICRUDProductService;

@Service
public class CRUDProductServiceImpl implements ICRUDProductService {

	private ArrayList<Product> allProducts = new ArrayList<Product>
	(Arrays.asList(
			new Product("Bumbieris", "Zaļš", 2, 2.99f),
			new Product("Šokolāde", "Zils", 15, 12.12f),
			new Product("Bumbieris", "Zaļš", 25, 14.14f)		
			));
	
	@Override
	public void createProduct(Product temp, int id) throws Exception {
		boolean isFound = false;
		for(Product prod: allProducts)
		{
			if(prod.getTitle().equals(temp.getTitle()) && 
			prod.getDescription().equals(temp.getDescription()) &&
			prod.getPrice() == temp.getPrice())
			{
				prod.setQuantity(prod.getQuantity()+temp.getQuantity());
				isFound = true;
				throw new Exception("Product exists and added to quantity");
			}
		
		}
		
		if(!isFound) {
			Product newProduct = new Product(temp.getTitle(), temp.getDescription(), temp.getQuantity(), temp.getPrice());
			allProducts.add(newProduct);
		}
		
	}

	@Override
	public ArrayList<Product> readAllProducts() {
		return allProducts;
		
	}

	@Override
	public Product readById(int id) throws Exception {
		
		for(Product prod: allProducts)
		{
			if(id == prod.getId())
			{
				return prod;
			}
		
		}
		throw new Exception("ID doesn't exist");
		
	}

	@Override
	public boolean updateById(int id, Product temp) throws Exception {
		for(Product prod: allProducts)
		{
			if(id == prod.getId())
			{
				prod.setTitle(temp.getTitle());
				prod.setDescription(temp.getDescription());
				prod.setPrice(temp.getPrice());
				prod.setQuantity(temp.getQuantity());
				return true;
			}
		
		}
		throw new Exception("ID doesn't exist");
	}

	@Override
	public void deleteById(int id) throws Exception {
		boolean isFound = false;
		for(Product prod: allProducts)
		{
			if(id == prod.getId())
			{
				allProducts.remove(prod);
				isFound = true;
			}
		
		}
		if(!isFound)
			throw new Exception("Product doesn't exist");
	}


}
