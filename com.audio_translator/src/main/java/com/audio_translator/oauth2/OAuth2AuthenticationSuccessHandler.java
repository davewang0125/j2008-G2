package com.audio_translator.oauth2;

import com.audio_translator.dao.UserRepository;
import com.audio_translator.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserRepository userRepository;

    public OAuth2AuthenticationSuccessHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        OAuth2User oAuth2User = token.getPrincipal();
        OAuth2UserInfo userInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(oAuth2User);
        if (userRepository.existsUserByUserName(userInfo.getId())) {
            User existingUser = userRepository.findByUserName(userInfo.getId());
            updateLastLoginTime(existingUser);
        } else {
            addNewUser(userInfo);
        }
        getRedirectStrategy().sendRedirect(request, response, "/hello" );
    }

    public void addNewUser(OAuth2UserInfo userInfo) {
        User user = new User();
        user.setUserName(userInfo.getId());
        user.setLastName(userInfo.getName());
        user.setEmail(userInfo.getEmail());
        user.setLoginSource(userInfo.getLoginSource());
        user.setLastlogin(LocalDateTime.now());
        userRepository.save(user);
        System.out.println("New User Added!");
    }

    public void updateLastLoginTime(User existingUser) {
        existingUser.setLastlogin(LocalDateTime.now());
        userRepository.save(existingUser);
        System.out.println("User updated!");
    }

}
