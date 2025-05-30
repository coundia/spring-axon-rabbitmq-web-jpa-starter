package com.groupe2cs.bizyhub.security.application.service;

import com.groupe2cs.bizyhub.security.infrastructure.entity.RefreshToken;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.RefreshTokenRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class RefreshTokenService {

	private final JwtDecoder jwtDecoder;
	private final RefreshTokenRepository refreshTokenRepository;

	@Transactional
	public void save(String token, MetaRequest metaRequest) {
		try {
			Jwt jwt = jwtDecoder.decode(token);
			String username = jwt.getSubject();
			Instant expiration = jwt.getExpiresAt();

			String tenantId = metaRequest.getTenantId();

//refreshTokenRepository.deleteByUsernameAndTenantId(username,tenantId);

			RefreshToken refreshToken = RefreshToken.builder()
					.id(UUID.randomUUID().toString())
					.token(token)
					.username(username)
					.tenant(new Tenant(tenantId))
					.expiration(expiration)
					.createdBy(new User(RequestContext.getUserId(jwt)))
					.build();

			refreshTokenRepository.save(refreshToken);

			log.info("Refresh token saved for {}", username);

		} catch (Exception e) {
			log.error("Error while saving refresh token: {}", e.getMessage(), e);
		}
	}
}

