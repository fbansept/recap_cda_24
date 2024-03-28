package com.example.recap.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtUtils {

    public String genererJwt(UserDetails userDetails) {

        String codeClient = userDetails.getUsername();

        return Jwts.builder()
                .setSubject(codeClient)
                .signWith(SignatureAlgorithm.HS256,"azerty")
                .compact();
    }

    public String getSubjectFromJwt(String jwt) {

        return Jwts.parser()
                .setSigningKey("azerty")
                .parseClaimsJws(jwt)
                .getBody()
                .getSubject();
    }

}
