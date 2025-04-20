package com.groupe2cs.bizyhub.security.application.service;
import com.groupe2cs.bizyhub.security.infrastructure.config.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

private final JwtProperties jwtProperties;

public JwtService(JwtProperties jwtProperties) {
this.jwtProperties = jwtProperties;
}

public String extractUsername(String token) {
return extractClaim(token, Claims::getSubject);
}

public Date extractExpiration(String token) {
return extractClaim(token, Claims::getExpiration);
}

public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
	return claimsResolver.apply(extractAllClaims(token));
	}

	public String generateToken(UserDetails userDetails) {
	return generateToken(new HashMap<>(), userDetails);
	}

	public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
	return Jwts.builder()
	.setClaims(extraClaims)
	.setSubject(userDetails.getUsername())
	.setIssuedAt(new Date())
	.setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpiration()))
	.signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
	.compact();
	}

	public boolean isTokenValid(String token, UserDetails userDetails) {
	final String username = extractUsername(token);
	return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
	}

	private boolean isTokenExpired(String token) {
	return extractExpiration(token).before(new Date());
	}

	private Claims extractAllClaims(String token) {
	return Jwts.parser()
	.setSigningKey(jwtProperties.getSecret())
	.parseClaimsJws(token)
	.getBody();
	}
}
