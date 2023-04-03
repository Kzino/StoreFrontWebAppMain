package com.astonengineers.version1.security.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

@Component
public class JwtService {

//    public static final String SECRET = "7134743777397A24432646294A404E635266556A586E3272357538782F412544";
//
//    public String generateToken(String UserName) {
//        Map<String, Object> claims = new HashMap<>();
//        return createToken(claims, UserName);
//    }
//
//    private String createToken(Map<String, Object> claims, String userName) {
//        return Jwts.builder()
//            .setClaims(claims)
//            .setSubject(userName)
//            .setIssuedAt(new Date(System.currentTimeMillis()))
//            .setExpiration(new Date(System.currentTimeMillis() + 1000*60*30))
//            .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
//
//    }
//
//    private Key getSignKey() {
//        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
//        return Keys.hmacShaKeyFor(keyBytes);
//
//    }
}
