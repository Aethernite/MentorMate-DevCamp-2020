package com.restfulapi.controller;

import com.restfulapi.dto.BookDTO;
import com.restfulapi.entity.Book;
import com.restfulapi.service.IBookService;
import com.restfulapi.exception.BookNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class BookController {
    private final IBookService bookService;
    private final ModelMapper mapper;

    @Autowired
    public BookController(IBookService bookService, ModelMapper mapper) {
        this.bookService = bookService;
        this.mapper = mapper;
    }


    @PostMapping("/save")
    public ResponseEntity<?> saveBook(@RequestBody BookDTO bookDTO){
        bookService.save(mapper.map(bookDTO,Book.class));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getAll(){
        Collection<BookDTO> dtos = bookService.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        if(dtos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(dtos);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBook(@RequestBody BookDTO bookDTO,@PathVariable("id") Integer id){
        try {
            bookService.update(id, mapper.map(bookDTO, Book.class));
        } catch(BookNotFoundException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Integer id){
        if(bookService.exists(id)) {
            bookService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    private BookDTO convertToDTO(Book book){
        return mapper.map(book,BookDTO.class);
    }

    private Book convertToEntity(BookDTO bookDTO){
        return mapper.map(bookDTO,Book.class);
    }

}
