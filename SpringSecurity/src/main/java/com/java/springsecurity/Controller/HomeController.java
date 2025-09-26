package com.java.springsecurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.springsecurity.Entity.MyUser;
import com.java.springsecurity.Repository.MyUserRepository;

import ch.qos.logback.core.pattern.color.BoldCyanCompositeConverter;
import jakarta.servlet.http.HttpServletRequest;
@RestController
public class HomeController {
	@Autowired
	private MyUserRepository myUserRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/registration/save")
	public MyUser saveUser(@RequestBody MyUser myUser) {
		myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
		return myUserRepository.save(myUser);
	}
	
	@GetMapping("/home")
	public String home(){
		return "Welcome to the Banking Application !!!";
	}
	@GetMapping("/myUser")
	public String userDetails() {
		String user_Name = "Abdul Shaik";
		long account_Number = 320922164244l;
		String IFSC_Number = "SBIN0001405";
		String Branch = "Kodur";
		String user_Address = "Y kota, Obulvaripalli(m), Annamaya(Dist), Andhra pradesh";
		String bank_Name = "State Bank of India";
//		System.out.println(user_Name);
//		System.out.println(account_Number);
//		System.out.println(IFSC_Number);
//		System.out.println(Branch);
//		System.out.println(bank_Name);
//		System.out.println(user_Address);
		return "These are Account details of the user\n" +user_Name + " " +account_Number + " " +IFSC_Number + " " +Branch + " " +user_Address + " " +bank_Name;	
	}
	@GetMapping("myUser/balance-details")
	public String userBalanceDetails() {
		double available_Balance = 545378.67;
		double current_balance = available_Balance - 45672.45;
		return "Current_balance is " +current_balance;
	}
	@GetMapping("myUser/contact-details")
	public String contact() {
		String msg = "Contact them to the below url or number";
		String url = "https://www.hdfcbank.com/";
		System.out.println(msg);
		System.out.println("url is " +url);
		return "These all are auto-generated";
	}
	@GetMapping("/admin/deduct")
	public String deduct() {
		return "I am the admin, i can only deduct";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
//	@GetMapping("/")
//	public String hello(HttpServletRequest request) {
//		return "2" + "3" + "\n" + request.getSession().getId();
//	}
//	@GetMapping("/bye")
//	public String home() {
//		return "Byee!!";
//	}
//}

//3ABFC43ED8DFCC49056A9B0AB383F113
//0FCDA5F772117C3DD949F3F173FDEFE3