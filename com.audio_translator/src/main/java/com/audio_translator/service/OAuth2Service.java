package com.audio_translator.service;

import com.audio_translator.dao.UserRepository;
import com.audio_translator.entity.LoginSource;
import com.audio_translator.entity.User;
import com.audio_translator.oauth2.OAuth2UserInfo;
import com.audio_translator.oauth2.OAuth2UserInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OAuth2Service extends DefaultOAuth2UserService {

    @Autowired
    private UserRepository userRepository;

    public OAuth2Service(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
        OAuth2UserInfo userInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(oAuth2UserRequest, oAuth2User);
        if (userRepository.existsUserByUserName(userInfo.getId())) {
            User existingUser = userRepository.findByUserName(userInfo.getId());
            updateLastLoginTime(existingUser);
        } else {
            addNewUser(oAuth2UserRequest, userInfo);
        }
        return oAuth2User;
    }

    private void updateLastLoginTime(User existingUser) {
        existingUser.setLastlogin(LocalDateTime.now());
        userRepository.save(existingUser);
    }

    public void addNewUser(OAuth2UserRequest oAuth2UserRequest, OAuth2UserInfo userInfo) {
        User user = new User();
        user.setUserName(userInfo.getId());
        user.setLastName(userInfo.getName());
        user.setEmail(userInfo.getEmail());
        user.setLoginSource(LoginSource.valueOf(oAuth2UserRequest.getClientRegistration().getClientId()));
        user.setLastlogin(LocalDateTime.now());
        userRepository.save(user);
    }

}
