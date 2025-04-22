package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.AuthResponseDto;
import com.groupe2cs.bizyhub.security.application.dto.RefreshTokenDto;
import com.groupe2cs.bizyhub.security.application.service.JwtService;
import com.groupe2cs.bizyhub.security.application.service.RefreshTokenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Auth", description = "Refresh token endpoints")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class RefreshTokenController {

	private final JwtService jwtService;
	private final RefreshTokenService refreshTokenService;
	private final UserDetailsService userDetailsService;

	@PostMapping("/refresh")
	public ResponseEntity<AuthResponseDto> refresh(@RequestBody RefreshTokenDto dto) {
		String username = jwtService.extractUsername(dto.getRefreshToken());

		if (!refreshTokenService.isValid(username, dto.getRefreshToken())) {
			return ResponseEntity.badRequest().body(AuthResponseDto.builder()
					.code(0)
					.message("Invalid refresh token")
					.build());
		}

		UserDetails user = userDetailsService.loadUserByUsername(username);
		String accessToken = jwtService.generateToken(user);

		return ResponseEntity.ok(AuthResponseDto.builder()
				.username(username)
				.token(accessToken)
				.code(1)
				.message("Token refreshed")
				.build());
	}
}
