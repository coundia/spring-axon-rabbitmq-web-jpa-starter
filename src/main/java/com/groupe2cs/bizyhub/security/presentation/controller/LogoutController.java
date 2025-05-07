package com.groupe2cs.bizyhub.security.presentation.controller;

	import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
	import com.groupe2cs.bizyhub.security.application.dto.*;
	import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
	import com.groupe2cs.bizyhub.security.infrastructure.repository.RefreshTokenRepository;
	import com.groupe2cs.bizyhub.security.application.service.*;
	import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


import java.util.List;

@Slf4j
@Tag(name = "Auth", description = "logout token")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class LogoutController {

private final JwtService jwtService;
private final RefreshTokenRepository refreshTokenRepository;

@PostMapping("/logout")
public ResponseEntity<AuthResponseDto> logout(@AuthenticationPrincipal Jwt jwt) {

	log.info("[LogoutController] Logout request received {} ", jwt.getSubject());

	MetaRequest metaRequest = new MetaRequest();
	metaRequest.setTenantId(RequestContext.getTenantId(jwt));

	String username =  jwt.getSubject();
	String tenantId = metaRequest.getTenantId();

	//refreshTokenRepository.deleteByUsernameAndTenantId(username,tenantId);

	return ResponseEntity.ok(
		AuthResponseDto.builder()
			.code(1)
			.message("Logout successfully")
			.build()
		);
	}
	}
