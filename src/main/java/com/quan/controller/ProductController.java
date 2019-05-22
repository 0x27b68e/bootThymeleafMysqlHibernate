package com.quan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.quan.model.Product;
import com.quan.service.ProductService;

@Controller
public class ProductController {

	@Autowired(required = true)
	private ProductService productService;
	
	@RequestMapping(value = "/")
	public ModelAndView getAllProduct() {
		List<Product> listProducts = productService.getAllProducts();
		ModelAndView modelAndView  = new ModelAndView("index");
		modelAndView.addObject("listProducts", listProducts);
		return modelAndView;
	}
	
	@GetMapping(value = "/add")
	public String showNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "addProduct";
		
	}
	@PostMapping(value = "/addProduct")
	public void addProduct(@ModelAttribute("product") Product product) {
		productService.addProduct(product);
	}
	
	@GetMapping(value = "/update/{id}")
	public String showUpdateProductForm(@PathVariable int id, Model model) {
		Product product = productService.getProduct(id);
		model.addAttribute("product", product);
		return "updateProduct";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
		return "redirect:/";
	}
	
}
