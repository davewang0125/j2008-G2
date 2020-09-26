package com.audio_translator.service;

import com.audio_translator.entity.LoginSource;
import com.audio_translator.entity.User;

public interface AuthService {

    User saveOAuth2User(User user);

}
