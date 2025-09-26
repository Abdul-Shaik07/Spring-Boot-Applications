package com.java.bookstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.java.bookstore.Entity.BookStore;
import com.java.bookstore.Service.BookStoreService;
@Controller
public class BookStoreController {
	@Autowired
	private BookStoreService bookStoreService;
	@GetMapping("/bookStore")
	public String homePage() {
		return"BookStore";
	}
	@PostMapping("/saveBook")
	public String saveBook(@RequestBody BookStore bookStore){
		bookStoreService.saveBook(bookStore);
		return "";
	}
	@GetMapping("/getBook/{bookName}")
	public String fetchBook(@PathVariable String bookName){
		bookStoreService.getBook(bookName);
		return "";
	}
	@DeleteMapping("/deleteBook/{bookName}")
	public String deleteBook(@PathVariable String bookName){
		bookStoreService.deleteBook(bookName);
		return "";
	}
	@PutMapping("/updateBook")
	public String updateBook(@RequestBody BookStore bookStore){
		bookStoreService.updateBook(bookStore);
		return "";
	}
}
