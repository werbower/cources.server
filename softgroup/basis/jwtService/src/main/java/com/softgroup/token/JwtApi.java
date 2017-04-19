package com.softgroup.token;

import com.softgroup.common.dbase.model.ProfileEntity;
import com.softgroup.common.dbase_embedded.model.RegisterEntity;

/**
 * Created by user on 28.03.2017.
 */
public interface JwtApi {
    String tokenFromProfile(ProfileEntity profileEntity,Long timeout);
    String tokenFromProfile(ProfileEntity profileEntity);
    TokenProfile profileFromToken(String token);

    String tokenFromRegister(RegisterEntity registerEntity,Long timeout);
    String tokenFromRegister(RegisterEntity registerEntity);
    RegisterEntity registerFromToken(String token);
}
