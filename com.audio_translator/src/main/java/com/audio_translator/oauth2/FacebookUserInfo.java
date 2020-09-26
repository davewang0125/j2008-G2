package com.audio_translator.oauth2;

import java.util.Map;

public class FacebookUserInfo extends OAuth2UserInfo {

    public FacebookUserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return attributes.get("id").toString();
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getIconUrl() {
        return null;
    }
}
