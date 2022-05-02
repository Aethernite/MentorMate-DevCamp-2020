package com.mentormate.devcamp.entity;

import com.mentormate.devcamp.enums.Genre;

import java.net.URL;
import java.util.List;

public class DigitalBook extends Book {
    private URL readingURL;
    private URL downloadURL;
    private boolean free;

    protected DigitalBook(String title, List<Author> authors, Genre genre, String summary, List<String> tags) {
        super(title, authors, genre, summary, tags, Type.DIGITAL);
    }
}
