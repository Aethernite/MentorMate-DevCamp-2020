package com.restfulapi.service;

import com.restfulapi.entity.Book;
import com.restfulapi.exception.BookNotFoundException;

import java.util.Collection;

public interface IBookService {
void save(Book book);
void update(Integer id, Book book) throws BookNotFoundException;
Collection<Book> findAll();
void delete(Integer id);
boolean exists(Integer id);
}
