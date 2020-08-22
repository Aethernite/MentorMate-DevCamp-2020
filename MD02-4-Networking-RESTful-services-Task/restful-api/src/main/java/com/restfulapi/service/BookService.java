package com.restfulapi.service;

import com.restfulapi.dao.BookRepository;
import com.restfulapi.entity.Book;
import com.restfulapi.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void update(Integer id, Book book) throws BookNotFoundException {
        Book obj = Optional.ofNullable(bookRepository.findOneById(id)).orElseThrow(() -> new BookNotFoundException("Book was not found"));
        if(obj != null) {
            obj.update(book);
            bookRepository.save(obj);
        }
    }

    @Override
    public Collection<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public boolean exists(Integer id){
        return bookRepository.existsById(id);
    }
}
