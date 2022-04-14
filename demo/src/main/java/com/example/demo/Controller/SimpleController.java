package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Product;

@Controller
public class SimpleController {
	@GetMapping("/simple") // Nostrādās uz šo url => localhost:8080/simple
	public String simpleFunc() {
		System.out.println("Hi!");
		return "home"; // ielādējam home.html lapu
	}
	
	@GetMapping("/msg")//localhost:8080/msg
	public String msgfunc(Model model) 
	{
		model.addAttribute("package", "Sveiciens no backend");
		return "msg-page";	
	}
	
	@GetMapping("/send-prod")//localhost:8080/send-prod
	public String SnedProdFunc (Model model) 
	{
		Product prodTest = new Product("Abols", "garsigs",10, 0.99f);
		model.addAttribute("package", prodTest);
		return "prod-page";
	
	}
	
	
	
	
}

// 1. izveidot kontroliera funkciju, lai varētu no backend nosūtīt ziņu
// 2. izveidot html lapa, kas so ziņu saņem un attēlo 

