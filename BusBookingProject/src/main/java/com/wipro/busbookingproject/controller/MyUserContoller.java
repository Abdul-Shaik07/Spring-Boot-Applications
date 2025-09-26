/*
 * package com.wipro.busbookingproject.controller;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.wipro.busbookingproject.entity.MyUser; import
 * com.wipro.busbookingproject.service.IMyUserService;
 * 
 * @RestController
 * 
 * @RequestMapping("/api/myUser") public class MyUserContoller {
 * 
 * @Autowired private IMyUserService iMyUserService;
 * 
 * @PostMapping("/public/saveUser") public ResponseEntity<MyUser>
 * saveUser(@RequestBody MyUser myUser) { return new
 * ResponseEntity<MyUser>(iMyUserService.saveUser(myUser), HttpStatus.OK); }
 * 
 * 
 * 
 * }
 */
