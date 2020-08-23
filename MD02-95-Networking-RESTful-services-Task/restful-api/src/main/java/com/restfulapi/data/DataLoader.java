package com.restfulapi.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restfulapi.dao.BookRepository;
import com.restfulapi.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {
    private final static String PATH = "./sample-data.json";
    private final BookRepository bookRepository;

    @Autowired
    public DataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = extractJSON(PATH);
        List<Book> books = mapper.readValue(json, new TypeReference<List<Book>>(){});
        bookRepository.saveAll(books);
    }

    private String extractJSON(String path) {
        StringBuilder sb = new StringBuilder();
        FileReader fr = null;
        try {
            fr = new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert fr != null;
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        while(line != null){
            try {
                line = br.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }
            sb.append(line);
        }
        return sb.toString();
    }
}
