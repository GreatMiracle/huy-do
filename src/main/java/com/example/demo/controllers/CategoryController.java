package com.example.demo.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.beans.CategoryModel;
import com.example.demo.entities.Account;
import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/create")
	public String create(@ModelAttribute("category") CategoryModel categoryModel) {

		return "/admin/categories/create";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model , @RequestParam(name = "size", defaultValue = "1") Integer size,
			@RequestParam(name = "page", defaultValue = "0") Integer page) {
		Category item = new Category();
		model.addAttribute("item", item);
		List<Category> items = categoryRepository.findAll();
		model.addAttribute("items", items);
		
		Pageable pageable = PageRequest.of(page, size);
		Page<Category> p = this.categoryRepository.findAll(pageable);
		model.addAttribute("data", p);
		return "/admin/categories/form";
	}

	@PostMapping("/store")
	public String store(CategoryModel model) {
		Category category = new Category();
		category.setName(model.getName());
		this.categoryRepository.save(category);
		return "redirect:/category/index";
	}

	@GetMapping("/delete/{id}")
	public String delete( @PathVariable("id") Category category) {

		System.out.println(category.getId());
		this.categoryRepository.delete(category);
		return "redirect:/category/index";
	}

	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(Model model,@ModelAttribute("categoryModel")  @PathVariable("id") Category category ,CategoryModel categoryModel ) {
		System.out.println(category.getId());
		model.addAttribute("id", category.getId() );
		categoryRepository.findById(category.getId());
		System.out.println(category.getName());
		model.addAttribute("name", category.getName() );
		return "/admin/categories/edit";
	}

	
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") Category categoryold, CategoryModel categoryModel) {
		Integer idInteger=categoryold.getId();
		System.out.println(idInteger);
		String nameString=categoryModel.getName();
		Category category=new Category();
		category.setName(nameString);
		category.setId(idInteger);
		 this.categoryRepository.save(category);
		return "redirect:/category/index";
	}
}
