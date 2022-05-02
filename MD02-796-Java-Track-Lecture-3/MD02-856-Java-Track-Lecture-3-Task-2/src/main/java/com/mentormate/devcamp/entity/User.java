package com.mentormate.devcamp.entity;

import com.mentormate.devcamp.enums.Action;
import com.mentormate.devcamp.enums.Sex;
import com.mentormate.devcamp.exception.BookNotFoundException;
import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class User {
    private String email;
    private String passwordHash;
    private String name;
    private int age;
    private Sex sex;
    private String address;
    private String city;
    private String country;
    private boolean consentGDPR;
    private List<Event> userHistory;
    private List<Book> borrowedBooks;

    public User(String email, String password, String name, int age, Sex sex, String address, String city, String country, boolean consentGDPR) {
        this.email = email;
        setPassword(password);
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.city = city;
        this.country = country;
        this.consentGDPR = consentGDPR;
    }

    private void setPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(
                    password.getBytes(StandardCharsets.UTF_8));
            passwordHash = new String(Hex.encode(hash));
        } catch (NoSuchAlgorithmException e) {
            e.getStackTrace();
        }
    }

    public void read(Book book) {
        Event event = new Event(Action.READ, book);
        userHistory.add(event);
    }

    public void borrow(Book book) {
        Event event = new Event(Action.BORROWED, book);
        userHistory.add(event);
        borrowedBooks.add(book);
    }

    public void download(Book book) {
        Event event = new Event(Action.BORROWED, book);
        userHistory.add(event);
    }

    public void postponeReturn(Book book) throws BookNotFoundException {
        if (!borrowedBooks.contains(book)) {
            throw new BookNotFoundException();
        }
        //TODO add implementation
    }

}
