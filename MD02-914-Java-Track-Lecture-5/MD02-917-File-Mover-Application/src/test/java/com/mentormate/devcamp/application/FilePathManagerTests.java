package com.mentormate.devcamp.application;

import com.mentormate.devcamp.application.exception.FileExtensionNotFoundException;
import com.mentormate.devcamp.application.exception.FileProviderNotFoundException;
import com.mentormate.devcamp.application.manager.FilePathManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

public class FilePathManagerTests {
    private FilePathManager manager;

    @BeforeEach
    public void init() {
        manager = new FilePathManager();
    }

    @Test
    public void extensionExtractTest() {
        Path path = Path.of("test.wav");
        String extension = null;
        try {
            extension = manager.extractExtension(path);
        } catch (FileExtensionNotFoundException ignored) {
        }
        Assertions.assertEquals(extension, "wav");
    }

    @Test
    public void extensionExtractTestException() {
        Path path = Path.of("test");
        Assertions.assertThrows(FileExtensionNotFoundException.class, () -> manager.extractExtension(path));
    }

    @Test
    public void providerExtractTest() {
        Path path = Path.of("provides/btv/test.wav");
        String provider = null;
        try {
            provider = manager.extractProvider(path);
        } catch (FileProviderNotFoundException ignored) {
        }
        Assertions.assertEquals(provider, "btv");
    }

    @Test
    public void providerExtractTestException() {
        Path path = Path.of("provides/");
        Assertions.assertThrows(FileProviderNotFoundException.class, () -> manager.extractProvider(path));
    }

}
