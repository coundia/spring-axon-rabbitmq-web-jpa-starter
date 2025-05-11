package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.application.service.*;
import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;

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

import java.util.List;

@Tag(name = "Auth", description = "Refresh token")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class RefreshTokenController {

private final JwtService jwtService;
private final RefreshTokenService refreshTokenService;
private final UserDetailsService userDetailsService;

@PostMapping("/refresh")
public ResponseEntity<AuthResponseDto> refresh(@AuthenticationPrincipal Jwt jwt) {

	if (jwt == null) {
	return ResponseEntity.badRequest()
	.body(AuthResponseDto.builder()
	.code(0)
	.message("Invalid JWT token")
	.build());
	}

	MetaRequest metaRequest = new MetaRequest();
	metaRequest.setTenantId(RequestContext.getTenantId(jwt));

	String username =  jwt.getSubject();

	UserPrincipal principal = (UserPrincipal) userDetailsService.loadUserByUsername(username);

	Authentication authentication = new UsernamePasswordAuthenticationToken(
	principal,
	null,
	principal.getAuthorities()
	);
	String accessToken = jwtService.generateToken(authentication, metaRequest);

	return ResponseEntity.ok(
	AuthResponseDto.builder()
		.token(accessToken)
		.username(username)
		.expirationAt(jwtService.extractExpiration(accessToken))
		.code(1)
		.message("Token refreshed successfully")
		.build()
	);
}
}
