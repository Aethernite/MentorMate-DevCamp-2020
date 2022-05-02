package com.mentormate.devcamp.application.extension;

import java.util.HashMap;
import java.util.Map;

public enum VideoExtension {
    MP4,
    M4A,
    M4V,
    F4V,
    F4A,
    M4B,
    M4R,
    F4B,
    MOV,
    OGG,
    OGA,
    OGV,
    OGX,
    WMV,
    WMA,
    ASF,
    WEBM,
    FLV,
    AVI,
    QUICKTIME,
    HDV,
    MPEG,
    MXF,
    WAV,
    LXF,
    GXF,
    VOB,
    _3GP("3gp"),
    _3GP2("3gp2"),
    _3G2("3g2"),
    _3GPP("3gpp"),
    _3GPP2("3gpp2"),
    OP1A,
    OP_ATOM("op-atom"),
    MPEG_TS("mpeg-ts"),
    TS,
    MPEG_2("mpeg-2"),
    MPEG_2_PS("mpeg-2-ps"),
    MPEG_2_TS("mpeg-2-ts");

    private final String name;
    private static final Map<String, VideoExtension> BY_NAME = new HashMap<>();

    static {
        for (VideoExtension e : values()) {
            BY_NAME.put(e.name, e);
        }
    }

    VideoExtension() {
        this.name = this.name().toLowerCase();
    }

    VideoExtension(String name) {
        this.name = name;
    }

    public static boolean contains(String name) {
        return BY_NAME.get(name)!=null;
    }

}
