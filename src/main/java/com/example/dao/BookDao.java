package com.example.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Book;

@Repository
public interface BookDao extends CrudRepository<Book, Integer>{

}
