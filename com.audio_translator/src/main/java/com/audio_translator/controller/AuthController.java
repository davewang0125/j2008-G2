package com.audio_translator.controller;


import com.audio_translator.oauth2.OAuth2UserInfo;
import com.audio_translator.oauth2.OAuth2UserInfoFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/name")
    public String getOAuth2UserName(@AuthenticationPrincipal OAuth2User oAuth2User) {
        return oAuth2User.getAttribute("name");
    }

    @GetMapping("/email")
    public String getOAuth2UserEmail(@AuthenticationPrincipal OAuth2User oAuth2User) {
        return oAuth2User.getAttribute("email");
    }

    @GetMapping("/loginSource")
    public String getOAuth2LoginSource(@AuthenticationPrincipal OAuth2User oAuth2User) {
        OAuth2UserInfo userInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(oAuth2User);
        return userInfo.getLoginSource().getString();
    }

}
