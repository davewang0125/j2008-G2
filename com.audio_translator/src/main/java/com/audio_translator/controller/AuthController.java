package com.audio_translator.controller;

import com.audio_translator.entity.LoginSource;
import com.audio_translator.entity.User;
import com.audio_translator.service.oauth2service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping("/auth")
public class AuthController {

}
