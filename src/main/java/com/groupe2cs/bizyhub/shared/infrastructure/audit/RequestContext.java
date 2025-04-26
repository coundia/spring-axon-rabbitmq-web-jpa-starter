package com.groupe2cs.bizyhub.shared.infrastructure.audit;

import com.groupe2cs.bizyhub.security.application.service.UserPrincipal;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.http.HttpStatus;
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
public static String getTenantId(Jwt jwt) {
Object claim = jwt.getClaims().get("tenantId");
if (claim == null) {
log.warn("Missing 'tenantId' in JWT claims");
return null;
}
return claim.toString();
}

}

