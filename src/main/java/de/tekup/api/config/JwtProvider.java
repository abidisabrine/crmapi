package de.tekup.api.config;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import de.tekup.api.models.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {

	@Value("VotreCleSecrete726873aabbccddabidiflagmlksqrs")
	private String JWT_SECRET;

	@Value("3600000")
	private Long JWT_EXPIRATIONS;

	public String generateToken(User user) {
		byte[] keyBytes = Decoders.BASE64.decode(JWT_SECRET);
		return Jwts
                .builder()
                .setClaims(null) //detail de user 
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() +JWT_EXPIRATIONS))
                .signWith(Keys.hmacShaKeyFor(keyBytes))  //, SignatureAlgorithm.HS256
                .compact();
	}
	
	//TODO : creér methode tokenverification 
	public boolean verifyToken(String token) { 
	       return true; 
	}

	

}
