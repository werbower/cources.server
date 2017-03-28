package com.softgroup.token;

import com.softgroup.common.dbase.model.ProfileEntity;

/**
 * Created by user on 28.03.2017.
 */
public interface JwtApi {
    String tokenFromProfile(ProfileEntity profileEntity);
    ProfileEntity profileFromToken(String token);
}
