package com.mentormate.devcamp.application.extension;

import java.util.HashMap;
import java.util.Map;

public enum ImageExtension {
    IMG,
    JPEG,
    JPG,
    PNG,
    GIF,
    TIFF,
    PSD,
    PDF,
    EPS,
    AI,
    INDD,
    RAW;
    private final String name;
    private static final Map<String, ImageExtension> BY_NAME = new HashMap<>();

    static {
        for (ImageExtension e : values()) {
            BY_NAME.put(e.name, e);
        }
    }

    ImageExtension() {
        this.name = this.name().toLowerCase();
    }

    public static boolean contains(String name) {
        return BY_NAME.get(name)!=null;
    }
}
