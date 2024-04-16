package com.ism.ecom.security.services.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";


//5minutes 3*3600*1000
    public String createToken(String username){
           return Jwts.builder()
                   .setClaims(new HashMap<String, Object>())
                   .setSubject(username)
                   .setIssuedAt(new Date(System.currentTimeMillis()))
                   .setExpiration(new Date(System.currentTimeMillis()+( 3*3600*1000)))
                   .signWith(getSignKey(), SignatureAlgorithm.HS256)
                   .compact();
    }

    private Key  getSignKey(){
        byte[] keyBytes =Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims extractAllCliams(String token){
       return Jwts.parserBuilder()
               .setSigningKey(getSignKey())
               .build()
               .parseClaimsJwt(token)
               .getBody();
    }

   public  <T> T extractCliam(String token, Function<Claims,T> claimsTFunction){
          Claims claims = extractAllCliams(token);
          return claimsTFunction.apply(claims);

   }

    public String  extractUsername(String token){
        return extractCliam(token,Claims::getSubject);
    }

}
