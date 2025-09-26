package com.java.bookstore.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.java.bookstore.Entity.BookStore;
import com.java.bookstore.Repository.BookStoreRepo;
@Service
public class BookStoreService {
	@Autowired
	private BookStoreRepo bookStoreRepo;
	// save the book
	public ResponseEntity<BookStore> saveBook(BookStore bookStore) {
		return new ResponseEntity<BookStore>(bookStoreRepo.save(bookStore), HttpStatus.CREATED);
	}
	// Fetch the book
	public ResponseEntity<BookStore> getBook(String bookName){
		 BookStore bookStore = bookStoreRepo.findById(bookName).get();
		 return new ResponseEntity<BookStore>(bookStore, HttpStatus.OK);
	}	
	// Delete the book 
	public ResponseEntity<String> deleteBook(String bookName) {
		if(bookStoreRepo.existsById(bookName)) {
			bookStoreRepo.deleteById(bookName);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	// update the book
	public ResponseEntity<BookStore> updateBook(BookStore bookStore) {
		BookStore update = bookStoreRepo.save(bookStore);
		return new ResponseEntity<BookStore>(update, HttpStatus.OK);
	}
}
