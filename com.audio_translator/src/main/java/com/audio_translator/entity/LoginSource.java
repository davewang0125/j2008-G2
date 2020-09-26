package com.audio_translator.entity;

public enum LoginSource {
    LINKEDIN("linkedin"), GOOGLE("google"), GITHUB("github"), LOCAL("local");

    private String loginSource;

    public String getProviderType() {
        return loginSource;
    }

    LoginSource(final String loginSource) {
        this.loginSource = loginSource;
    }
}
