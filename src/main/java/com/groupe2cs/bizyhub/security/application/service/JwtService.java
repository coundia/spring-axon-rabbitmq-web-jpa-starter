package com.groupe2cs.bizyhub.security.application.service;
import com.groupe2cs.bizyhub.security.infrastructure.config.*;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;


@Slf4j
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

UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

String userId = userPrincipal.getId();

String tenantId = userPrincipal.getTenantId();

if (tenantId == null) {
	tenantId = "NA";
}


if(userId == null) {
	throw new IllegalArgumentException("User ID ");
}

var claims = JwtClaimsSet.builder()
.issuedAt(now)
.expiresAt(now.plus(tokenValidityInSeconds, ChronoUnit.SECONDS))
.subject(authentication.getName())
.claim("userId", userId)
.claim("tenantId", tenantId)
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

public String extractTenantId(String token) {
Jwt jwt = jwtDecoder.decode(token);
return jwt.getClaim("tenantId");
}

public String extractUserId(String token) {
Jwt jwt = jwtDecoder.decode(token);
return jwt.getClaim("userId");
}

public static   String extractClaim(Authentication auth, String claim) {
if (auth == null || !auth.isAuthenticated()) {
log.error("Authentication is null or not authenticated");
return "";
}

Object principal = auth.getPrincipal();
if (principal instanceof Jwt jwt) {
return  jwt.getClaimAsString(claim);
}

if (principal instanceof UserPrincipal userPrincipal) {
	if(claim.equals("userId")) {
		return userPrincipal.getId();
	}
	if (claim.equals("tenantId")) {
		return userPrincipal.getTenantId();
	}
	return userPrincipal.getUsername();
}

log.warn("Principal is not on good instance  ");

return "";
}

}

