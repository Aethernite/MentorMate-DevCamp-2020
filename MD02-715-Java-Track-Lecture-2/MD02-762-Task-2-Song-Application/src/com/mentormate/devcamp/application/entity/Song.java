package com.mentormate.devcamp.application.entity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.Duration;

public class Song {
    private String title;
    private String lyrics;
    private Genre genre;
    private Duration duration;

    public Song(String title, String lyrics, Genre genre, Duration duration) {
        this.title = title;
        this.lyrics = lyrics;
        this.genre = genre;
        this.duration = duration;
    }

    public boolean compareGenre(Genre genre){
        return this.genre == genre;
    }

    public void printLyrics(){
        System.out.println(lyrics);
    }

    public void printDuration(){
        System.out.println(String.format("Duration: %d:%d",duration.getSeconds()/60, duration.getSeconds()%60));
    }

    public static String getClassCharacteristics(){
        StringBuilder sb = new StringBuilder();
        Class thisClass = Song.class;
        sb.append("Class name: " + thisClass.getSimpleName()).append(System.lineSeparator());
        sb.append("===========================")
                .append(System.lineSeparator());
        Method[] methods = thisClass.getDeclaredMethods();
        Field[] fields = thisClass.getDeclaredFields();
        sb.append("All fields inside class:")
                .append(System.lineSeparator());
        sb.append("===========================")
                .append(System.lineSeparator());
        for(Field field: fields){
            sb.append("Field: ")
                    .append(field.getName())
                    .append("Type: ")
                    .append(field.getType())
                    .append(System.lineSeparator());
        }
        sb.append("===========================")
                .append(System.lineSeparator());
        sb.append("All methods inside class:")
                .append(System.lineSeparator());
        sb.append("===========================")
                .append(System.lineSeparator());
        for(Method method: methods){
            sb.append("Method name: ")
                    .append(method.getName())
                    .append(" Return type: ")
                    .append(method.getAnnotatedReturnType().getType())
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String getTitle() {
        return title;
    }


}
