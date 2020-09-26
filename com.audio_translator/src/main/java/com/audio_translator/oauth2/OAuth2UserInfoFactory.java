package com.audio_translator.oauth2;

import com.audio_translator.entity.LoginSource;
import com.audio_translator.exception.OAuth2AuthenticationSupportException;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        String registerationId = oAuth2UserRequest.getClientRegistration().getClientId();
        if (registerationId.equalsIgnoreCase(LoginSource.GOOGLE.getLoginSource())) {
            return new GoogleUserInfo(oAuth2User.getAttributes());
        } else if (registerationId.equalsIgnoreCase(LoginSource.GITHUB.getLoginSource())) {
            return new GithubUserInfo(oAuth2User.getAttributes());
        } else if (registerationId.equalsIgnoreCase(LoginSource.FACEBOOK.getLoginSource())) {
            return new FacebookUserInfo(oAuth2User.getAttributes());
        } else {
            throw new OAuth2AuthenticationSupportException("Login with " + registerationId + " is not support yet.");
        }
    }
}
