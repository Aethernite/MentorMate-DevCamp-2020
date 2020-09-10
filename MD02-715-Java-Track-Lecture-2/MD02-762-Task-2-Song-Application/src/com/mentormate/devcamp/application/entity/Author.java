package com.mentormate.devcamp.application.entity;

/**
 * The class Author.
 * <p>
 * The class represents an Author for a song and his information.
 */
public class Author {
    private String name;
    private int age;
    private Song song;

    /**
     * Instantiates a new Author.
     *
     * @param name the name
     * @param age  the age
     * @param song the song
     */
    public Author(String name, int age, Song song) {
        this.name = name;
        this.age = age;
        this.song = song;
    }

    /**
     * Print author info.
     */
    public void printAuthorInfo() {
        System.out.println("Author: " + name);
        System.out.println("Age: " + age);
    }

    /**
     * Print author info and the title of his song.
     */
    public void print() {
        System.out.println("Song title: " + song.getTitle());
        printAuthorInfo();
    }

}
