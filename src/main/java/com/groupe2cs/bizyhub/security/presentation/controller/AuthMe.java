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
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Tag(name = "Auth", description = "Users infos")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthMe {

	@GetMapping("/me")
	@Operation(
			summary = "Get current authenticated user",
			description = "Returns username and authorities of the current user"
	)
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "User info",
					content = @Content(schema = @Schema(implementation = ApiResponseDto.class))
			),
			@ApiResponse(
					responseCode = "401",
					description = "Unauthorized"
			)
	})
	public ApiResponseDto me(@AuthenticationPrincipal UserPrincipal user) {
		return ApiResponseDto.ok(
				Map.of(
						"username", user.getUsername(),
						"roles", user.getRoles(),
						"authorities", user.getAuthorities()
				)
		);
	}
}
