package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BookDao;
import com.example.entity.Book;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookService {
	
	@Autowired
	private BookDao bookDao;
	
	public Iterable<Book> findAll() {
		return bookDao.findAll();
	}
	
	public Optional<Book> getById(int id) {
		return bookDao.findById(id);
	}
	
	public Book createNew(Book book) {
		log.info("New Book -> {}", book);
		return bookDao.save(book);
	}
	
	public int editBook(int bookId, String title) {
		Optional<Book> foundBook = bookDao.findById(bookId);
		if(foundBook.isPresent()) {
			Book book = foundBook.get();
			book.setTitle(title);
			bookDao.save(book);
			return 1;
		} else {
			return 0;
		}
	}
	
	public int deleteBook(int bookId) {
		Optional<Book> foundBook = bookDao.findById(bookId);
		if(foundBook.isPresent()) {
			bookDao.delete( foundBook.get() );
			return 1;
		} else {
			return 0;
		}
	}

}
