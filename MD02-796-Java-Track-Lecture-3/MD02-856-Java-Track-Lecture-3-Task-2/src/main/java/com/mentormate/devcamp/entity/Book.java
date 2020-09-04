package com.mentormate.devcamp.entity;

import com.mentormate.devcamp.enums.Genre;

import java.util.List;

public abstract class Book {
    protected String title;
    protected List<Author> authors;
    protected Genre genre;
    protected String summary;
    protected List<String> tags;
    protected Type type;

    protected Book(String title, List<Author> authors, Genre genre, String summary, List<String> tags, Type type) {
        this.title = title;
        this.authors = authors;
        this.genre = genre;
        this.summary = summary;
        this.tags = tags;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getSummary() {
        return summary;
    }

    public List<String> getTags() {
        return tags;
    }
}
