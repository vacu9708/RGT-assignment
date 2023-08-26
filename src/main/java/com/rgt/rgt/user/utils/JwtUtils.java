package com.rgt.rgt.user.utils;

import java.security.Key;
import java.util.Date;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class JwtUtils {
    static Key jwtKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode("aerkjfsdanfjsd9865agcdvhtdf265494651kdnfhfaljkasfdj"));
    
    public static String generateToken(Map<String, Object> claims, int expiredIn){
        return Jwts.builder()
            .setHeaderParam("typ", "JWT")
            .setHeaderParam("alg", "HS256")
            .addClaims(claims)
            .setExpiration(new Date(System.currentTimeMillis() + expiredIn))
            .signWith(jwtKey)
            .compact();
    }

    public static Claims getTokenClaims(String token){
        return Jwts.parserBuilder()
            .setSigningKey(jwtKey)
            .build()
            .parseClaimsJws(token)
            .getBody();
    }
}
