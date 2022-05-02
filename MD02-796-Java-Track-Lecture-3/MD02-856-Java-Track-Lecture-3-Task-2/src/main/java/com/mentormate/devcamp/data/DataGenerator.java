package com.mentormate.devcamp.data;

import com.mentormate.devcamp.entity.Author;
import com.mentormate.devcamp.entity.PhysicalBook;
import com.mentormate.devcamp.entity.User;
import com.mentormate.devcamp.enums.Genre;
import com.mentormate.devcamp.enums.Sex;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    public static List<User> generateUsers() {
        User user = new User("test@google.com", "obichampici", "Petko Ivanov", 21, Sex.MALE, "Drujba", "Sofia", "Bulgaria", true);
        User user1 = new User("pencho@google.com", "123456789abc3", "Pencho Ivanov", 21, Sex.MALE, "Drujba", "Sofia", "Bulgaria", true);
        User user2 = new User("t43@google.com", "obi543ci", "Ivana Ivanova", 26, Sex.FEMALE, "Drujba", "Sofia", "Bulgaria", true);
        User user3 = new User("t645@google.com", "ob54mpici", "Mariya Ivanova", 23, Sex.FEMALE, "Drujba", "Sofia", "Bulgaria", true);
        User user4 = new User("t256@google.com", "obi543i", "Petran Ivanov", 30, Sex.MALE, "Drujba", "Sofia", "Bulgaria", true);
        User user5 = new User("test@google.com", "obichampici", "Kamen Ivanov", 36, Sex.MALE, "Drujba", "Sofia", "Bulgaria", true);
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        return users;
    }

    public static List<PhysicalBook> generatePhysicalBooks(List<Author> authors) {
        List<String> tags = new ArrayList<>();
        tags.add("Bad Ass");
        tags.add("Educational");
        List<String> tags1 = new ArrayList<>();
        tags.add("Art");
        tags.add("Classic");
        PhysicalBook book = new PhysicalBook("Java Algorithms and Data Structures", authors.subList(0, 2), Genre.HORROR, "Java is pain, java is life", tags);
        PhysicalBook book1 = new PhysicalBook("C# is not as good as java", authors.subList(3, 4), Genre.CLASSIC, "Java is good", tags1);
        PhysicalBook book2 = new PhysicalBook("How to Javascript", authors.subList(4, 5), Genre.HORROR, "Learn java then script", tags);
        PhysicalBook book3 = new PhysicalBook("How to sword fight", authors.subList(3, 4), Genre.DRAMA, "Swords swords swords!", tags1);
        List<PhysicalBook> books = new ArrayList<>();
        books.add(book);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        return books;
    }


    public static List<Author> generateAuthors() {
        Author author = new Author("Ivan", "Petrov", "Bulgaria", LocalDate.of(1998, 4, 20));
        Author author1 = new Author("Preslava", "Petrova", "Bulgaria", LocalDate.of(1992, 4, 20));
        Author author2 = new Author("Gergana", "Hadjieva", "Bulgaria", LocalDate.of(1997, 4, 20));
        Author author3 = new Author("Iva", "Mladenova", "Bulgaria", LocalDate.of(2000, 4, 20));
        Author author4 = new Author("Ivan", "Petrov", "Bulgaria", LocalDate.of(1995, 4, 20));
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        authors.add(author1);
        authors.add(author2);
        authors.add(author3);
        authors.add(author4);

        return authors;
    }
}
