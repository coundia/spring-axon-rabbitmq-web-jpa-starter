package com.groupe2cs.bizyhub.shared.infrastructure.audit;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestContext {

	public static String getUserId(Jwt jwt) {
		Object claim = jwt.getClaims().get("userId");
		if (claim == null) {
			log.error("Missing 'userId' in JWT claims");
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User ID is required");
		}
		return claim.toString();
	}

}

