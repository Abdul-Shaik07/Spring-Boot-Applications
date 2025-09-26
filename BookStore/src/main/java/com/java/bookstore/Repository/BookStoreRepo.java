package com.java.bookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.bookstore.Entity.BookStore;
@Repository
public interface BookStoreRepo extends JpaRepository<BookStore, String>{

}
