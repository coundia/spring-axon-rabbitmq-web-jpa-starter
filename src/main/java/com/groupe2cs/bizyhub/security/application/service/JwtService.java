package com.groupe2cs.bizyhub.security.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JwtService {

	public static final MacAlgorithm JWT_ALGORITHM = MacAlgorithm.HS512;
	private final JwtEncoder jwtEncoder;
	private final JwtDecoder jwtDecoder;
	private final RefreshTokenService refreshTokenService;

	@Value("${security.jwt.expiration}")
	private long tokenValidityInSeconds;

	public String generateToken(Authentication authentication) {
		Instant now = Instant.now();
		var authorities = authentication.getAuthorities().stream()
				.map(Object::toString)
				.collect(Collectors.joining(" "));

		var claims = JwtClaimsSet.builder()
				.issuedAt(now)
				.expiresAt(now.plus(tokenValidityInSeconds, ChronoUnit.SECONDS))
				.subject(authentication.getName())
				.claim("scope", authorities)
				.build();

		var header = JwsHeader.with(JWT_ALGORITHM).build();

		String token = jwtEncoder.encode(JwtEncoderParameters.from(header, claims)).getTokenValue();

		refreshTokenService.save(token);

		return token;
	}

	public String extractUsername(String token) {
		Jwt jwt = jwtDecoder.decode(token);
		return jwt.getSubject();
	}

	public Instant extractExpiration(String token) {
		Jwt jwt = jwtDecoder.decode(token);
		return jwt.getExpiresAt();
	}
}

