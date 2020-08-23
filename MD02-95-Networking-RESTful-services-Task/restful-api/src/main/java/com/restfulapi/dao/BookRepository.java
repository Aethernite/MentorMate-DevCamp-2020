package com.restfulapi.dao;

import com.restfulapi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findOneById(Integer id);
}
