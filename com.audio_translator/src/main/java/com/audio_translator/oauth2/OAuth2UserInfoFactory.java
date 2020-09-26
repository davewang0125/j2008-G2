package com.audio_translator.oauth2;

import com.audio_translator.entity.LoginSource;
import com.audio_translator.exception.OAuth2AuthenticationSupportException;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class OAuth2UserInfoFactory {
    //TODO modify  github and facebook login
    public static OAuth2UserInfo getOAuth2UserInfo(OAuth2User oAuth2User) {
        if (oAuth2User.getAttribute("sub") != null) {
            return new GoogleUserInfo(oAuth2User.getAttributes());
        } else if (oAuth2User.getAttribute("name") != null) {
            return new GithubUserInfo(oAuth2User.getAttributes());
        } else if (oAuth2User.getAttribute("facebook") != null) {
            return new FacebookUserInfo(oAuth2User.getAttributes());
        } else {
            throw new OAuth2AuthenticationSupportException("This third part Login is not support yet.");
        }
    }
}
