package com.mentormate.devcamp.application.manager;

import com.mentormate.devcamp.application.exception.FileExtensionNotFoundException;
import com.mentormate.devcamp.application.exception.FileProviderNotFoundException;

import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The File path manager.
 * <p>
 * Manages the extractions of the provider and the extension of the file using regex
 */
public class FilePathManager {
    private static final String EXTENSION_REGEX = "\\.([\\w\\d]+)";
    private static final String PROVIDER_REGEX = "^provides[\\\\/]([\\w-_]+)[\\\\/]";
    private final Pattern extension = Pattern.compile(EXTENSION_REGEX);
    private final Pattern provider = Pattern.compile(PROVIDER_REGEX);

    /**
     * Extract extension.
     *
     * @param path the path
     * @return the extension by String
     * @throws FileExtensionNotFoundException if the file extension is not found
     */
    public String extractExtension(Path path) throws FileExtensionNotFoundException {
        String ext = path.toString();
        Matcher matcher = extension.matcher(ext);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new FileExtensionNotFoundException();
    }

    /**
     * Extract provider.
     *
     * @param path the path
     * @return the provider in String
     * @throws FileProviderNotFoundException if the provider is not found
     */
    public String extractProvider(Path path) throws FileProviderNotFoundException {
        Matcher matcher = provider.matcher(path.toString());
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new FileProviderNotFoundException();
    }
}
