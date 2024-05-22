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

@Component
public class JwtProvider {

	@Value("abc")
	private String JWT_SECRET;

	@Value("800000")
	private Long JWT_EXPIRATIONS;

	public String generateToken(User user) {
		return "";
		//return Jwts.builder().setSubject(user.getEmail())
			//	.setExpiration(new Date(System.currentTimeMillis() * 800000))
				//.signWith(SignatureAlgorithm.PS384, "abc").compact();
	}

	

}
