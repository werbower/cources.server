package com.softgroup.restserver.config.security;

import com.softgroup.common.dbase.model.ProfileEntity;
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
    private ProfileEntity profileEntity;

    public ProfileUser() {
    }
    public ProfileUser(ProfileEntity profileEntity) {
        this.profileEntity = profileEntity;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public ProfileEntity getDetails() {
        return profileEntity;
    }

    @Override
    public String getPrincipal() {
        if (profileEntity==null)
            return null;
        else
            return profileEntity.getId();
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
        if (profileEntity==null)
            return null;
        else
            return profileEntity.getName();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_REGISTER"));
        return list;
    }
}
