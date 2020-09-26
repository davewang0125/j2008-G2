package com.audio_translator.entity;

public enum LoginSource {
    LINKEDIN("linkedin"),
    GOOGLE("https://accounts.google.com"),
    GITHUB("github");

    private String loginSource;

    public String getLoginSource() {
        return loginSource;
    }

    LoginSource(final String loginSource) {
        this.loginSource = loginSource;
    }
}
