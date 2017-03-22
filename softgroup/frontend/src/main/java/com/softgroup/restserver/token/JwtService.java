package com.softgroup.restserver.token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by user on 21.03.2017.
 */
@Component
public class JwtService {
    private byte[] secretKey = new byte[]{1,45,15,12,85};

    public String tokenOut(){
        Date expDate = new Date(System.currentTimeMillis()+1*60*60*1000);

        return Jwts.builder()
                .setSubject("user")
                .setExpiration(expDate)
                .setIssuer("issuer")
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }


}
