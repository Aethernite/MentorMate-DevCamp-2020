package com.mentormate.devcamp.data;

import com.mentormate.devcamp.entity.*;
import com.mentormate.devcamp.enums.Genre;

import java.util.*;
import java.util.stream.Collectors;

public class Database {
    private Map<PhysicalBook, Integer> physicalBooks;
    private List<Book> books;
    private List<Book> borrowed;
    private List<User> users;
    private List<Author> authors;

    public void init() {
        users = DataGenerator.generateUsers();
        authors = DataGenerator.generateAuthors();
        List<PhysicalBook> physBooks = DataGenerator.generatePhysicalBooks(authors);
        physicalBooks = new HashMap<>();
        physBooks.forEach(book -> physicalBooks.put(book, (int) Math.round(Math.random() * 10)));

    }

    public Database() {
        physicalBooks = new HashMap<>();
        books = new ArrayList<>();
        borrowed = new ArrayList<>();
        users = new ArrayList<>();

    }

    public List<Book> getBooksByTitle(String title) {
        return books
                .stream()
                .filter(book -> book.getTitle().equals(title))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Book> getBooksByAuthorName(String... name) {
        String firstName = name.length > 0 ? name[0]:"";
        String lastName = name.length > 1 ? name[1]:"";
        return books
                .stream()
                .filter(book -> book.getAuthors()
                        .stream()
                        .anyMatch(author -> author.getFirstName().equals(firstName)
                                || author.getLastName().equals(lastName)))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Book> getBooksByGenre(List<Book> books, Genre genre) {
        return books
                .stream()
                .filter(book -> book.getGenre().equals(genre))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Book> getBooksByTag(String... tags) {
        return books
                .stream()
                .filter(book -> {
                    List<String> bookTags = book.getTags();
                    for (String tag : tags) {
                        for (String bookTag : bookTags) {
                            if (tag.equals(bookTag)) {
                                return false;
                            }
                        }
                    }
                    return true;
                })
                .collect(Collectors.toUnmodifiableList());
    }


}
