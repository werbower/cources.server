package com.softgroup.token;

import com.softgroup.common.dbase.model.ProfileEntity;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by user on 21.03.2017.
 */
@Component
public class JwtService {
    private byte[] secretKey = new byte[]{1,45,15,12,85};

    public String tokenOut(ProfileEntity profileEntity){
        Date expDate = new Date(System.currentTimeMillis()+1*60*60*1000);

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

    public ProfileEntity fromToken(String token){
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
}
