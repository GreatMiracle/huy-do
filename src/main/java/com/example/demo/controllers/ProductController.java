package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.beans.ProductModel;
import com.example.demo.entities.Account;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	@GetMapping("/index")
	public String index(Model model, @RequestParam(name = "size", defaultValue = "1") Integer size,
			@RequestParam(name = "page", defaultValue = "0") Integer page) {
		Product product = new Product();
		
		model.addAttribute("product", product);
		List<Product> lstProduct = productRepository.findAll();
		model.addAttribute("listpro", lstProduct);
		
		
		
		
		Pageable pageable = PageRequest.of(page, size);
		Page<Product> p = this.productRepository.findAll(pageable);
		model.addAttribute("data", p);
		return "/admin/products/form";
	}
	
	@PostMapping("/store")
	public String store(ProductModel productModel) {
		Product product=new Product();
		product.setName(productModel.getName());
		product.setImage(productModel.getName());
		product.setPrice(productModel.getPrice());
		//date
		Date date=productModel.getCreatedDate();
		product.setCreatedDate(date);
		
		product.setAvailable(productModel.getAvailable());
		Category category=new Category();
		category.setId(productModel.getCategory());
		this.categoryRepository.findById(productModel.getCategory());
		product.setCategory(category);
		this.productRepository.save(product);
		return "/admin/products/form";
	}
}
