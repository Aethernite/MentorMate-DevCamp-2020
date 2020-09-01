package com.mentormate.devcamp.application.entity;

public class Author {
    private String name;
    private int age;
    private Song song;

    public Author(String name, int age, Song song) {
        this.name = name;
        this.age = age;
        this.song = song;
    }

    public void printAuthorInfo(){
        System.out.println("Author: " + name);
        System.out.println("Age: " + age);
    }

    public void print(){
        System.out.println("Song title: " + song.getTitle());
        printAuthorInfo();
    }

}
