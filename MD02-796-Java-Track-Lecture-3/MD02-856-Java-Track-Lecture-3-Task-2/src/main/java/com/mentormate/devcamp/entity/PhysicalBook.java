package com.mentormate.devcamp.entity;

import com.mentormate.devcamp.enums.Genre;

import java.util.List;

public class PhysicalBook extends Book {

    public PhysicalBook(String title, List<Author> authors, Genre genre, String summary, List<String> tags) {
        super(title, authors, genre, summary, tags, Type.PHYSICAL);
    }

}
