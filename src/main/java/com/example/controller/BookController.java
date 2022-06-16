package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Book;
import com.example.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/getallbooks")
	public ResponseEntity<List<Book>> showAll() {
		List<Book> list = (List<Book>) bookService.findAll();
		if(list.size() < 1) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	@PostMapping("/addnewbook")
	public Book ceateNew(@RequestBody Book book) {
		return bookService.createNew(book);
	}
	
	@PutMapping("/editbook")
	public int editBook(@RequestBody Book book) {
		return bookService.editBook(book.getId(), book.getTitle());
	}
	
	@DeleteMapping("/deletebook/{id}")
	public int deleteBook(@PathVariable int id) {
		return bookService.deleteBook(id);
	}
}
