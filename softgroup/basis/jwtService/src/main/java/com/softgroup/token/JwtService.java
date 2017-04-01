package com.softgroup.token;

import com.softgroup.common.dbase.model.ProfileEntity;

import com.softgroup.common.dbase_embedded.model.RegisterEntity;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by user on 21.03.2017.
 */
@Component
public class JwtService implements JwtApi{
    private byte[] secretKey = new byte[]{1,45,15,12,85};

    @Override
    public String tokenFromProfile(ProfileEntity profileEntity) {
        Long timeout = 1*60*60*1000L;
        return tokenFromProfile(profileEntity,timeout);
    }

    public String tokenFromProfile(ProfileEntity profileEntity, Long timeout){
        if (profileEntity==null)
            return null;
        //
        Date expDate = new Date(System.currentTimeMillis()+timeout);

        Claims claims = Jwts.claims();
        claims.setExpiration(expDate);
        claims.setId(profileEntity.getId());
        claims.setSubject(profileEntity.getName());
        claims.put("phoneNumber",profileEntity.getPhoneNumber());

        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secretKey);

        return jwtBuilder.compact();
    }

    public ProfileEntity profileFromToken(String token){
        if (token==null)
            return null;
        //
        Claims claims;
        ProfileEntity resEntity = null;
        JwtParser jwtParser = Jwts.parser().setSigningKey(secretKey);
        try {
            claims = jwtParser.parseClaimsJws(token).getBody();
        } catch (Exception e){
            return null;
        }

        String locId =claims.getId();
        String locPhoneNumber = (String) claims.get("phoneNumber");
        String locName = claims.getSubject();
        if (locId==null || locPhoneNumber==null || locName==null)
            return null;

        resEntity = new ProfileEntity();
        resEntity.setId(locId);
        resEntity.setPhoneNumber(locPhoneNumber);
        resEntity.setName(locName);

        return resEntity;
    }

    //

    @Override
    public String tokenFromRegister(RegisterEntity registerEntity, Long timeout) {
        if (registerEntity==null)
            return null;
        //
        Date expDate = new Date(System.currentTimeMillis()+timeout);

        Claims claims = Jwts.claims();
        claims.setExpiration(expDate);
        claims.setId(registerEntity.getId());
        claims.setSubject(registerEntity.getDeviceId());
        claims.put("phoneNumber",registerEntity.getPhoneNumber());

        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secretKey);

        return jwtBuilder.compact();
    }

    @Override
    public String tokenFromRegister(RegisterEntity registerEntity) {
        long timeout = 10*60*1000L;
        return tokenFromRegister(registerEntity,timeout);
    }

    @Override
    public RegisterEntity registerFromToken(String token) {
        if (token==null)
            return null;
        //
        Claims claims;
        RegisterEntity resEntity = null;
        JwtParser jwtParser = Jwts.parser().setSigningKey(secretKey);
        try {
            claims = jwtParser.parseClaimsJws(token).getBody();
        } catch (Exception e){
            return null;
        }
        String locId =claims.getId();
        String locPhoneNumber = (String) claims.get("phoneNumber");
        String locDeviceId = claims.getSubject();
        if (locId==null || locPhoneNumber==null || locDeviceId==null)
            return null;

        resEntity = new RegisterEntity();
        resEntity.setId(locId);
        resEntity.setPhoneNumber(locPhoneNumber);
        resEntity.setDeviceId(locDeviceId);

        return resEntity;
    }
}
