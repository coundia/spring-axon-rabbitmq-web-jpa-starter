package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.AuthResponseDto;
import com.groupe2cs.bizyhub.security.application.dto.RefreshTokenDto;
import com.groupe2cs.bizyhub.security.application.service.JwtService;
import com.groupe2cs.bizyhub.security.application.service.RefreshTokenService;
import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class RefreshTokenController {

	private final JwtService jwtService;
	private final RefreshTokenService refreshTokenService;
	private final UserDetailsService userDetailsService;

	@PostMapping("/refresh")
	public ResponseEntity<ApiResponseDto> refresh(@RequestBody RefreshTokenDto dto) {
		String username = jwtService.extractUsername(dto.getRefreshToken());

		if (!refreshTokenService.isValid(username, dto.getRefreshToken())) {
			return ResponseEntity.badRequest().body(ApiResponseDto.error("Invalid refresh token"));
		}

		//UserDetails user = userDetailsService.loadUserByUsername(username);

		Authentication authentication = new UsernamePasswordAuthenticationToken(
				username,
				null,
				List.of(new SimpleGrantedAuthority("ROLE_USER"))
		);
		String accessToken = jwtService.generateToken(authentication);

		return ResponseEntity.ok(ApiResponseDto.ok(AuthResponseDto.builder()
				.username(username)
				.token(accessToken)
				.build()));
	}
}
