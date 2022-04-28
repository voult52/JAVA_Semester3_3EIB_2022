package com.example.demo.Controller;



import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	//--------------------------------ADD BY ID --------------------------------------------//
	
	
	@GetMapping("/add") //localhost:8080/product/add
	public String getProductAdd(Product product)// padodam skatam tukšu produktu
	{

		return "prod-add-page"; // parādīs prod-add-page.html lapu, kura ????????
	}
	
	
	
	@PostMapping("/add")
	public String postProductAdd( @Valid Product product, BindingResult result) {
		//System.out.print(product);
		if(!result.hasErrors()) {
		try {
			prodService.createProduct(product);
			return "redirect:/product/all";
					
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/msg";
			
		}
		
		}
		return "prod-add-page";
	}
	
	//--------------------------------UPDATE BY ID --------------------------------------------//
	
	@GetMapping("/update/{id}")
	public String getProductUpdate(@PathVariable(name = "id") int id, Model model){
		
		try {
			Product prod = prodService.readById(id);
			model.addAttribute("product", prod);
			return "update-page";//izsaukts prod-page.html padod izfiltrēto produktu
 		} catch (Exception e) {
			// TODO Auto-generated catch block
 			e.printStackTrace();
 			return "error-page";
			
		}
	
		
	}
	
	
	@PostMapping("/update/{id}")
	public String postProductUpdate(@PathVariable(name = "id") int id,  Product product) {
		
		try {
			prodService.updateById(id,product);
			return "redirect:/product/all";
					
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/error-page";
			
		}
		
		
	}
	
	
	//--------------------------------DELETE BY ID --------------------------------------------//
	
	@GetMapping("/delete/{id}")
	public String getProductDelete(@PathVariable(name = "id") int id, Model model){
		
		try {
			prodService.deleteById(id);
			ArrayList<Product> allProductsForsending = prodService.readAllProducts();
			model.addAttribute("product", allProductsForsending);
			return "redirect:/product/all";//izsaukts prod-page.html padod izfiltrēto produktu
 		} catch (Exception e) {
			// TODO Auto-generated catch block
 			e.printStackTrace();
 			return "error-page";
			
		}
	
		
	}
	

	
	
	
	//1.Get kontorliera funkcija, kura spēj no url nolasīt id
	//un pēc tā id nolasīt no servisa konkrēto produktu
	//un to padod caur model.addAtribute
	
	//2.html lapa produktu reģidēšanai
	//mainās url adreeses
	
	
	//@GetMapping("product/update__${id}__") //localhost:8080/product/add
	
	
	//3.post ontroliera funkicja, saņem reģidēto produktu un caur servisu šo produktu saglabā
	//un redirect - /all/id. kur id ir atbilstoša vērtība
	
}	












