package com.wipro.trainbookingproject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wipro.trainbookingproject.entity.MyUser;
import com.wipro.trainbookingproject.service.IMyUserService;

@RestController
@RequestMapping("/api/myuser")
public class MyUserController {
	@Autowired
	IMyUserService iMyUserService;
	
	@PostMapping("/public/insert")
	public MyUser insertUser(@RequestBody MyUser myUser) {
		// TODO Auto-generated method stub
		return iMyUserService.insertUser(myUser);
	}
}
