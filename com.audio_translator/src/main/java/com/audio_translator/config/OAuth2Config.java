package com.audio_translator.config;

import com.audio_translator.oauth2.OAuth2AuthenticationSuccessHandler;
import com.audio_translator.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class OAuth2Config extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthService authService;
    @Autowired
    private OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // @formatter:off
//        httpSecurity
//                .authorizeRequests(a -> a
//                        .antMatchers("/", "/error", "/webjars/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .exceptionHandling(e -> e
//                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//                )
//                .csrf(c -> c
//                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                )
//                .logout(l -> l
//                        .logoutSuccessUrl("/").permitAll()
//                );
        httpSecurity
                .oauth2Login()
//                    .userInfoEndpoint()
//                        .userService(authService)
//                        .and()
//                    .tokenEndpoint()
//                        .accessTokenResponseClient(oAuth2AccessTokenResponseClient)
//                        .and()
                    .successHandler(oAuth2AuthenticationSuccessHandler);
        // @formatter:on
    }
}
