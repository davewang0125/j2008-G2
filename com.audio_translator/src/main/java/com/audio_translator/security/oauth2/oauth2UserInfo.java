package com.audio_translator.security.oauth2;

import java.util.Map;

public abstract class oauth2UserInfo {
    protected Map<String, Object> attributes;

    public oauth2UserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public abstract String getId();

    public abstract String getName();

    public abstract String getEmail();
}
