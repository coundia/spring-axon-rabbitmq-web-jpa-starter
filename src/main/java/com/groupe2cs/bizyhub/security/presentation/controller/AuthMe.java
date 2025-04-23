package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.service.UserPrincipal;
import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@Tag(name = "Auth", description = "Users infos")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthMe {

	private final UserDetailsService userDetailsService;

	@GetMapping("/me")
	@Operation(summary = "Get current authenticated user", description = "Returns username from token")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "User info", content = @Content(schema = @Schema(implementation = ApiResponseDto.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized")
	})
	public ResponseEntity<ApiResponseDto> me(@AuthenticationPrincipal Jwt jwt) {

		if (jwt == null) {
			log.warn("Auth/me JWT is null");
			return ResponseEntity.status(401).body(ApiResponseDto.error("Unauthorized"));
		}


		log.info("Auth/me User claims: {}", jwt.getClaims());
		String username = jwt.getSubject();

		UserPrincipal userPrincipal = (UserPrincipal) userDetailsService.loadUserByUsername(username);

		return ResponseEntity.ok(ApiResponseDto.ok(
				Map.of(
						"username", username,
						"roles", userPrincipal.getRoles(),
						"authorities", userPrincipal.getAuthorities()
				)
		));
	}
}

