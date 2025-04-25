package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.AuthResponseDto;
import com.groupe2cs.bizyhub.security.application.service.JwtService;
import com.groupe2cs.bizyhub.security.application.service.RefreshTokenService;
import com.groupe2cs.bizyhub.security.application.service.UserPrincipal;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

		String username = jwt.getSubject();

		UserPrincipal principal = (UserPrincipal) userDetailsService.loadUserByUsername(username);

		Authentication authentication = new UsernamePasswordAuthenticationToken(
				principal,
				null,
				principal.getAuthorities()
		);
		String accessToken = jwtService.generateToken(authentication);

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
