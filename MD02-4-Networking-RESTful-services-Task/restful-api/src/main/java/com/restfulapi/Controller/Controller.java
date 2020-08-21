package com.restfulapi.Controller;

import com.restfulapi.DAO.BookRepository;
import com.restfulapi.Entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/save")
    public void saveBook(@RequestBody Book book){
          bookRepository.save(book);
    }

    @GetMapping("/getAll")
    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public void updateBook(@RequestBody Book book,@PathVariable("id") Integer id){
        Book obj = bookRepository.findOneById(id);
        obj.update(book);
        bookRepository.save(obj);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable("id") Integer id){
        bookRepository.deleteById(id);
    }
}
