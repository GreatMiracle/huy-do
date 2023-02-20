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

import com.example.demo.beans.AccountModel;
import com.example.demo.entities.Account;
import com.example.demo.repositories.AccountRepository;

@Controller
@RequestMapping("/admin/account")
public class AccountController {
	@Autowired
	private AccountRepository accountRepository;

	@GetMapping("/create")
	public String create(@ModelAttribute("account") AccountModel acc) {
		System.out.println("Đã tới đây");
		return "/admin/accounts/create";
	}

	@GetMapping("/index")
	public String index(Model model, @RequestParam(name = "size", defaultValue = "1") Integer size,
			@RequestParam(name = "page", defaultValue = "0") Integer page) {
		Account account = new Account();
		model.addAttribute("account", account);
		List<Account> lstAccounts = accountRepository.findAll();
		model.addAttribute("listacc", lstAccounts);
		
		Pageable pageable = PageRequest.of(page, size);
		Page<Account> p = this.accountRepository.findAll(pageable);
		model.addAttribute("data", p);
		return "/admin/accounts/index";
	}

	@PostMapping("/store")
	public String store(AccountModel accountModel) { // Lưu
		Account account = new Account();
		account.setUsername(accountModel.getUsername());
		account.setPassword(accountModel.getPassword());
		account.setFullname(accountModel.getFullname());
		account.setEmail(accountModel.getEmail());
		account.setPhoto(accountModel.getPhoto());
		account.setAdmin(accountModel.getAdmin());
		this.accountRepository.save(account);
		return "redirect:/admin/accounts/create";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Account account) // Xóa
	{
		System.out.println(account.getEmail());
		this.accountRepository.delete(account);
		return "redirect:/admin/account/index";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(Model model, @ModelAttribute("categoryModel") @PathVariable("id") Account account,
			AccountModel accountModel) {
		model.addAttribute("id", account.getId());
		accountRepository.findById(account.getId());
		model.addAttribute("fullname", account.getFullname());
		model.addAttribute("username", account.getUsername());
		model.addAttribute("email", account.getEmail());
		model.addAttribute("photo", account.getPhoto());
		model.addAttribute("admin", account.getAdmin());
		model.addAttribute("password", account.getPassword());
		return "/admin/accounts/edit";
	}

	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") Account accountOld, AccountModel accountModel ) {
		Integer idInteger = accountOld.getId();
		System.out.println(idInteger);
		String fullnameString = accountModel.getFullname();
		String usernameString = accountModel.getUsername();
		String emailString = accountModel.getEmail();
		String photoString = accountModel.getPhoto();
		String passwordString = accountModel.getPassword();
		Integer adminInteger = accountModel.getAdmin();
		Account account = new Account();
		account.setFullname(fullnameString);
		System.out.println(account.getFullname());
		account.setUsername(usernameString);
		account.setEmail(emailString);
		account.setPhoto(photoString);
		account.setPassword(passwordString);
		account.setAdmin(adminInteger);
		account.setId(idInteger);
		this.accountRepository.save(account);
		return "redirect:/admin/account/index";
	}
//	@GetMapping("/table")
//	public String table(					//paging table
//		Model model,
//		@RequestParam(name="size", defaultValue="1") Integer size,
//		@RequestParam(name="page", defaultValue="0") Integer page
//	) {
//		Pageable pageable = PageRequest.of(page, size);
//		Page<Account> p = this.accountRepository.findAll(pageable);
//		model.addAttribute("data", p);
//		return "admin/accounts/table";
//	}

}
