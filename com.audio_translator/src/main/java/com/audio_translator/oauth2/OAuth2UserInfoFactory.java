package com.audio_translator.oauth2;

import com.audio_translator.entity.LoginSource;
import com.audio_translator.exception.OAuth2AuthenticationSupportException;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.security.AuthProvider;
import java.util.Map;

public class OAuth2UserInfoFactory {
    //TODO modify  github and facebook login
//    public static OAuth2UserInfo getOAuth2UserInfo(OAuth2User oAuth2User) {
//        if(registrationId.equalsIgnoreCase(LoginSource.GOOGLE.toString())) {
//            return new GoogleUserInfo(attributes);
//        } else if (registrationId.equalsIgnoreCase(LoginSource.FACEBOOK.toString())) {
//            return new FacebookUserInfo(attributes);
//        } else if (registrationId.equalsIgnoreCase(LoginSource.GITHUB.toString())) {
//            return new GithubUserInfo(attributes);
//        } else {
//            throw new OAuth2AuthenticationSupportException("Sorry! Login with " + registrationId + " is not supported yet.");
//        }
//    }
    public static OAuth2UserInfo getOAuth2UserInfo(OAuth2User oAuth2User) {
        if (oAuth2User.getAttribute("sub") != null) {
            return new GoogleUserInfo(oAuth2User.getAttributes());
//        } else if (oAuth2User.getAttribute("name") != null) {
//            return new GithubUserInfo(oAuth2User.getAttributes());
        } else if (oAuth2User.getAttribute("facebook") != null) {
            return new FacebookUserInfo(oAuth2User.getAttributes());
        } else {
            return new GithubUserInfo(oAuth2User.getAttributes());
//            throw new OAuth2AuthenticationSupportException("This third part Login is not support yet.");
        }
    }
}
