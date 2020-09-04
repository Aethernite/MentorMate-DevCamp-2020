package com.mentormate.devcamp.application;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class FileMoverApplicationTests {
    private FileMoverApplication application;

    @BeforeEach
    public void init() {
        application = new FileMoverApplication();

    }

    @Test
    public void fileMoverApplicationOutputTestImage() {
        File inputFile = new File("provides\\btv\\btv_logo.png");
        application.start();
        Path output = Path.of("output\\btv\\images\\btv_logo.png"); //<- The expected output
        File outputFile = new File(String.valueOf(output));
        Assertions.assertTrue(outputFile.exists());
        boolean fileEquals = false;
        try {
            fileEquals = FileUtils.contentEquals(inputFile, outputFile);
        } catch (IOException e) {
            Assertions.fail();
        }
        Assertions.assertTrue(fileEquals);
    }

    @Test
    public void fileMoverApplicationOutputTestError() {
        File inputFile = new File("provides\\btv\\errorbtv");
        application.start();
        Path output = Path.of("output\\btv\\errors\\errorbtv"); //<- The expected output
        File outputFile = new File(String.valueOf(output));
        Assertions.assertTrue(outputFile.exists());
        boolean fileEquals = false;
        try {
            fileEquals = FileUtils.contentEquals(inputFile, outputFile);
        } catch (IOException e) {
            Assertions.fail();
        }
        Assertions.assertTrue(fileEquals);
    }

    @Test
    public void fileMoverApplicationOutputTestVideo() {
        File inputFile = new File("provides\\btv\\btv_theme.wav");
        application.start();
        Path output = Path.of("output\\btv\\videos\\btv_theme.wav"); //<- The expected output
        File outputFile = new File(String.valueOf(output));
        Assertions.assertTrue(outputFile.exists());
        boolean fileEquals = false;
        try {
            fileEquals = FileUtils.contentEquals(inputFile, outputFile);
        } catch (IOException e) {
            Assertions.fail();
        }
        Assertions.assertTrue(fileEquals);
    }

    @Test
    public void fileMoverApplicationOutputTestXML() {
        File inputFile = new File("provides\\btv\\btv_source_code.xml");
        application.start();
        Path output = Path.of("output\\btv\\xml\\btv_source_code.xml"); //<- The expected output
        File outputFile = new File(String.valueOf(output));
        Assertions.assertTrue(outputFile.exists());
        boolean fileEquals = false;
        try {
            fileEquals = FileUtils.contentEquals(inputFile, outputFile);
        } catch (IOException ignored) {
        }
        Assertions.assertTrue(fileEquals);
    }

}
