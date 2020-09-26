package com.audio_translator.service;

import com.audio_translator.dao.AuthRepository;

import com.audio_translator.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthRepository authRepository;

    public AuthServiceImpl(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public User saveOAuth2User(User user) {
        return authRepository.save(user);
    }
}
