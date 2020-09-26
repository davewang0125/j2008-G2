package com.audio_translator.oauth2;

import com.audio_translator.dao.UserRepository;
import com.audio_translator.entity.LoginSource;
import com.audio_translator.entity.User;
import com.audio_translator.exception.OAuth2AuthenticationSupportException;
import com.audio_translator.service.oauth2service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
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
        System.out.println(oauth2UserLoginSource((OAuth2UserRequest) request, oAuth2User));
        //TODO: 登陆以后的redirectURL修改
        getRedirectStrategy().sendRedirect(request, response, "/hello" );
    }

    public String oauth2UserLoginSource(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        String registerationId = oAuth2UserRequest.getClientRegistration().getClientId();
        if (registerationId.equalsIgnoreCase(LoginSource.GOOGLE.getLoginSource())) {
            return LoginSource.GOOGLE.getLoginSource();
        } else if (registerationId.equalsIgnoreCase(LoginSource.GITHUB.getLoginSource())) {
            return LoginSource.GITHUB.getLoginSource();
        } else if (registerationId.equalsIgnoreCase(LoginSource.FACEBOOK.getLoginSource())) {
            return LoginSource.FACEBOOK.getLoginSource();
        } else {
            throw new OAuth2AuthenticationSupportException("Login with " + registerationId + " is not support yet.");
        }
    }
}
