package com.mentormate.devcamp.application;

import com.mentormate.devcamp.application.exception.FileExtensionNotFoundException;
import com.mentormate.devcamp.application.exception.FileProviderNotFoundException;
import com.mentormate.devcamp.application.extension.ImageExtension;
import com.mentormate.devcamp.application.extension.VideoExtension;
import com.mentormate.devcamp.application.manager.FilePathManager;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * The File mover application.
 */
public class FileMoverApplication {
    private final List<Path> filePaths;
    private final FilePathManager manager;
    private static final String OUTPUT = "output";

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        var application = new FileMoverApplication();
        application.start();
    }

    /**
     * Instantiates a new File mover application.
     */
    public FileMoverApplication() {
        this.filePaths = new ArrayList<>();
        this.manager = new FilePathManager();
    }

    /**
     * The start method of the application.
     */
    public void start() {
        try {
            cleanOutputDirectory();
            extractFilePaths();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        moveFiles();
    }

    private void cleanOutputDirectory() throws IOException {
        FileUtils.cleanDirectory(new File(OUTPUT));
    }

    private void extractFilePaths() throws IOException {
        try (Stream<Path> paths = Files.walk(Paths.get("provides/"))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(filePaths::add);
        }
    }

    private void moveFiles() {
        filePaths.forEach(path -> {
            String extension;
            String provider = null;
            try {
                extension = manager.extractExtension(path.getFileName()); //Extracts extension from the full path
            } catch (FileExtensionNotFoundException e) {
                extension = null;
            }

            try {
                provider = manager.extractProvider(path); //Extracts the provider of the files from the full path
            } catch (FileProviderNotFoundException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }

            String folder = getFolder(extension); //Gets the folder in which the file must be moved depending on extension

            try {
                Files.createDirectories(Paths.get(OUTPUT, provider, folder)); //Creates the directories for the file
                Path output = Paths.get(OUTPUT, provider, folder, path.getFileName().toString()); //Creates the output path for the current file
                //Files.move(path, output); //Moves the file into the new output path and deletes them from the old folder
                Files.copy(path, output); //USED FOR TESTING ONLY!
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }

        });
    }

    private String getFolder(String extension) {
        if (extension==null) {
            return "errors";
        }
        if (extension.equalsIgnoreCase("xml")) {
            return "xml";
        }

        boolean image = ImageExtension.contains(extension);
        boolean video = VideoExtension.contains(extension);
        if (image) {
            return "images";
        }
        if (video) {
            return "videos";
        }
        return "errors";
    }
}
