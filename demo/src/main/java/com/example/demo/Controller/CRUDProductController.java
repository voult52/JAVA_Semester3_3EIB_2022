package com.example.demo.Controller;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Product;
import com.example.demo.services.ICRUDProductService;

@Controller
@RequestMapping("/product") //localhost:8080/product
public class CRUDProductController {

	@Autowired
	private ICRUDProductService prodService;
	
	@GetMapping("/all")
	public String getProductAll(Model model) {
		
		ArrayList<Product> allProductsForSending = prodService.readAllProducts();
		model.addAttribute("package", allProductsForSending);
		return "prod-all-page"; //parādisies prod-all-page.html lapa. 
	}

/*
	@GetMapping("/one") //localhost:8080/product/one?id=1
	public String getPoductOne(@RequestParam(name = "id") int id, Model model)
	{
		try {
			Product productForSending = prodService.readById(id);
			model.addAttribute("package", productForSending);
			return "prod-page";//izsaukts prod-page.html padod izfiltrēto produktu
 		} catch (Exception e) {
			// TODO Auto-generated catch block
 			e.printStackTrace();
 			return "error-page";
			
		}
	}
	*/
	
		
	@GetMapping("/all/{id}") //localhost:8080/product/all/1
	public String getProductAllWithOutQestionMark(@PathVariable(name = "id") int id, Model model){
		
		try {
			Product productForSending = prodService.readById(id);
			model.addAttribute("package", productForSending);
			return "prod-page";//izsaukts prod-page.html padod izfiltrēto produktu
 		} catch (Exception e) {
			// TODO Auto-generated catch block
 			e.printStackTrace();
 			return "error-page";
			
		}
	
		
	}
	
	
	
	
	
}	