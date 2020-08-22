package com.restfulapi.Controller;

import com.restfulapi.DTO.BookDTO;
import com.restfulapi.Entities.Book;
import com.restfulapi.Services.IBookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class Controller {
    private final IBookService bookService;
    private final ModelMapper mapper;

    @Autowired
    public Controller(IBookService bookService, ModelMapper mapper) {
        this.bookService = bookService;
        this.mapper = mapper;
    }

    @PostMapping("/save")
    public void saveBook(@RequestBody BookDTO bookDTO){
        bookService.save(mapper.map(bookDTO,Book.class));
    }

    @GetMapping("/get/all")
    public Collection<BookDTO> getAll(){
          return bookService.findAll()
                  .stream()
                  .map(this::convertToDTO)
                  .collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public void updateBook(@RequestBody BookDTO bookDTO,@PathVariable("id") Integer id){
        bookService.update(id,mapper.map(bookDTO,Book.class));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable("id") Integer id){
       bookService.delete(id);
    }

    private BookDTO convertToDTO(Book book){
        return mapper.map(book,BookDTO.class);
    }

    private Book convertToEntity(BookDTO bookDTO){
        return mapper.map(bookDTO,Book.class);
    }

}
