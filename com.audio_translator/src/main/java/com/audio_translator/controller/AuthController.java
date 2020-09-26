package com.audio_translator.controller;

import com.audio_translator.dao.UserRepository;
import com.audio_translator.entity.LoginSource;
import com.audio_translator.entity.User;
import com.audio_translator.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;


@RestController
//@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping("/name")
    public String getOAuth2UserName(@AuthenticationPrincipal OAuth2User oAuth2User) {
        return oAuth2User.getAttribute("name");
    }

    @RequestMapping("/email")
    public String getOAuth2UserEmail(@AuthenticationPrincipal OAuth2User oAuth2User) {
        return oAuth2User.getAttribute("email");
    }

    //TODO:每个登陆的网站给的信息不一样，这部分还需要改
    @RequestMapping("/loginSource")
    public String getOAuth2UserLoginSource(@AuthenticationPrincipal OAuth2User oAuth2User) {
        String loginSource = oAuth2User.getAttribute("iss");
        if (loginSource.equals(LoginSource.GOOGLE.getLoginSource())) {
            return oAuth2User.getAttribute("iss");
        }
        //TODO FACEBOOK, GITHUB
        return "";
    }


    @RequestMapping("/img")
    public String getOAuth2UserIconUrl(@AuthenticationPrincipal OAuth2User oAuth2User) {
        String url = "";
        //TODO
        return url;
    }

    @PostMapping("/saveUser")
    public User saveUser(@AuthenticationPrincipal OAuth2User oAuth2User) {
        User newUser = new User();
        newUser.setUserName(oAuth2User.getAttribute("name"));
        newUser.setUserName(oAuth2User.getAttribute("email"));
        return authService.saveOAuth2User(newUser);
    }

}
