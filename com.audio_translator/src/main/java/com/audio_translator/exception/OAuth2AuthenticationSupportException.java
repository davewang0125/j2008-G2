package com.audio_translator.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * @author <Bofeng Ding>
 * @version 1.0
 * @date 9/26/20 2:24 上午
 */
public class OAuth2AuthenticationSupportException extends AuthenticationException {
    public OAuth2AuthenticationSupportException(String msg, Throwable t) {
        super(msg, t);
    }

    public OAuth2AuthenticationSupportException(String msg) {
        super(msg);
    }
}
