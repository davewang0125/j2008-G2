package com.audio_translator.service.oauth2service;

import com.audio_translator.dao.AuthRepository;
import com.audio_translator.entity.User;
import com.audio_translator.oauth2.OAuth2UserInfo;
import org.springframework.security.oauth2.core.user.OAuth2User;

public interface AuthService {
    String getOAuth2UserId(OAuth2User oAuth2User);

    String getOAuth2UserName(OAuth2User oAuth2User);

    String getOAuth2UserEmail(OAuth2User oAuth2User);

}
