package com.mentormate.devcamp.application;

import com.mentormate.devcamp.application.entity.Author;
import com.mentormate.devcamp.application.entity.Genre;
import com.mentormate.devcamp.application.entity.Song;
import com.mentormate.devcamp.application.lyrics.Lyrics;

import java.time.Duration;

/**
 * The Song application class.
 */
public class SongApplication {

    /**
     * The start method of the application.
     */
    public void start() {
        Song song = new Song("Thunderstruck", Lyrics.THUNDERSTRUCK, Genre.ROCK, Duration.ofMinutes(3).plus(Duration.ofSeconds(45)));
        Author author = new Author("AC/DC", 30, song);
        testMethods(song, author);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SongApplication application = new SongApplication();
        application.start();
    }

    private void testMethods(Song song, Author author) {
        author.print();
        System.out.println();
        author.printAuthorInfo();
        System.out.println();
        System.out.println("Is the song POP: " + song.compareGenre(Genre.POP));
        System.out.println();
        song.printDuration();
        System.out.println();
        song.printLyrics();
        System.out.println();
        System.out.println(Song.getClassCharacteristics());
    }
}
