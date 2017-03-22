package com.softgroup.restserver.config.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Created by user on 22.03.2017.
 */
@Component
public class MyProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication.getName().equals("REGISTER")){
            return authentication;
        }else
            return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return MyProvider.class.equals(authentication);
    }
}
