package com.groupe2cs.bizyhub.shared;

import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
public class TestTokenFactory {

	@Autowired
	private JwtEncoder jwtEncoder;

	public String generateAdminToken(String tenantId, String userId) {
		Instant now = Instant.now();
		JwtClaimsSet claims = JwtClaimsSet.builder()
				.subject("admin")
				.issuedAt(now)
				.expiresAt(now.plus(1, ChronoUnit.DAYS))
				.claim("scope", "READ IS_ADMIN DELETE WRITE")
				.claim("isAdmin", true)
				.claim("tenantId", tenantId)
				.claim("userId", userId)
				.build();

		return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
	}
}
