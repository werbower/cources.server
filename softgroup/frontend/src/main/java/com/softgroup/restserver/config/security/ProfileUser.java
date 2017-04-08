package com.softgroup.restserver.config.security;

import com.softgroup.token.UserProfile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by user on 22.03.2017.
 */
@Component
public class ProfileUser implements Authentication {
    private UserProfile profile;

    public ProfileUser() {
    }
    public ProfileUser(UserProfile profile) {
        this.profile = profile;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public UserProfile getDetails() {
        return profile;
    }

    @Override
    public String getPrincipal() {
        if (profile==null)
            return null;
        else
            return profile.getId();
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        if (profile==null)
            return null;
        else
            return profile.getName();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_REGISTER"));
        return list;
    }
}
