package com.audio_translator.oauth2;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        LocalDateTime lastLogin = LocalDateTime.now();
        OAuth2User oAuth2User = token.getPrincipal();
//        System.out.println(oauth2UserLoginSource((OAuth2UserRequest) request, oAuth2User));
        //TODO: 登陆以后的redirectURL修改
        getRedirectStrategy().sendRedirect(request, response, "/hello" );
    }

}
