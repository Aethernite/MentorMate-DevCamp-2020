package com.mentormate.devcamp.entity;

import com.mentormate.devcamp.enums.Action;

import java.time.LocalDateTime;

public class Event {
    private final Action action;
    private final LocalDateTime timestamp;
    private final Book book;

    public Event(Action action, Book book) {
        this.action = action;
        this.book = book;
        this.timestamp = LocalDateTime.now();
    }

    public Action getAction() {
        return action;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Book getBook() {
        return book;
    }
}
