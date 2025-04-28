package com.groupe2cs.bizyhub.security.application.service;

import com.groupe2cs.bizyhub.security.application.dto.AuthRequestDto;
import com.groupe2cs.bizyhub.security.application.dto.AuthResponseDto;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;

	public AuthResponseDto handle(
			AuthRequestDto request,
			MetaRequest metaRequest
	) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getUsername(),
						request.getPassword()
				)
		);


		UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
		String tenantId = principal.getTenantId();
		log.debug("Tenant dans le principal : {}", tenantId);


		if (!tenantId.equals(metaRequest.getTenantId())) {
			log.error("Mismatch de tenant : {} vs {}", tenantId, metaRequest.getTenantId());
			throw new IllegalArgumentException(
					"Tenant mismatch: user belongs to " + tenantId +
							" but request asked for " + metaRequest.getTenantId()
			);
		}


		String token = jwtService.generateToken(authentication, metaRequest);


		return AuthResponseDto.builder()
				.code(1)
				.message("Login successful")
				.token(token)
				.tenant(tenantId)
				.username(authentication.getName())
				.expirationAt(jwtService.extractExpiration(token))
				.build();
	}
}



