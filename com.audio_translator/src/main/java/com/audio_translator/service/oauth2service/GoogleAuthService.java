package com.audio_translator.service.oauth2service;

import com.audio_translator.dao.AuthRepository;
import com.audio_translator.entity.User;
import com.audio_translator.oauth2.OAuth2UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service("google")
public class GoogleAuthService implements AuthService {

    @Override
    public String getOAuth2UserId(OAuth2User oAuth2User) {
        return oAuth2User.getAttribute("sub");
    }

    @Override
    public String getOAuth2UserName(OAuth2User oAuth2User) {
        return oAuth2User.getAttribute("name");
    }

    @Override
    public String getOAuth2UserEmail(OAuth2User oAuth2User) {
        return oAuth2User.getAttribute("email");
    }

}
