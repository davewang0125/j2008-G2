package com.audio_translator.config;

import com.audio_translator.oauth2.OAuth2AuthenticationSuccessHandler;
import com.audio_translator.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.Map;

@Configuration
public class OAuth2Config extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthService authService;
    @Autowired
    private OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .authorizeRequests(a -> a
                        .antMatchers("/", "/error", "/webjars/**").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2Login()
                    .successHandler(oAuth2AuthenticationSuccessHandler);
        // @formatter:on
    }

//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//
//        httpSecurity
//                .oauth2Login()
//                    .successHandler(oAuth2AuthenticationSuccessHandler);
//        // @formatter:on
//    }
}
