package com.restfulapi.DAO;

import com.restfulapi.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findOneById(Integer id);
    void deleteByTitle(String title);
}
