package com.audio_translator.entity;

public enum LoginSource {
    FACEBOOK("facebook"),
    GOOGLE("google"),
    GITHUB("github");

    private String loginSource;

    public String getString() {
        return loginSource;
    }

    LoginSource(final String loginSource) {
        this.loginSource = loginSource;
    }
}
