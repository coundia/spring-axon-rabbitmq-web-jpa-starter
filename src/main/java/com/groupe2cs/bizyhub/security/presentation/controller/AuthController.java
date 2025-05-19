package com.groupe2cs.bizyhub.security.presentation.controller;
import com.groupe2cs.bizyhub.security.application.service.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

@Tag(name = "Auth", description = "Endpoints for authentication")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

private final AuthService authService;
private final CurrentTenantIdentifierResolver currentTenantIdentifierResolver;

@PostMapping("/login")
@Operation(
summary = "Authenticate user",
description = "Authenticates a user with username and password, and returns a JWT token",
requestBody = @RequestBody(
description = "Authentication credentials",
required = true,
content = @Content(schema = @Schema(implementation = AuthRequestDto.class))
)
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Login successful", content = @Content(schema = @Schema(implementation = AuthResponseDto.class))),
@ApiResponse(responseCode = "401", description = "Unauthorized - invalid credentials", content = @Content(schema = @Schema(implementation = AuthResponseDto.class)))
})
public ResponseEntity<AuthResponseDto> authenticate(
	@org.springframework.web.bind.annotation.RequestBody AuthRequestDto request
	) {

try {

		MetaRequest metaRequest = new MetaRequest();
		metaRequest.setTenantId(currentTenantIdentifierResolver.resolveCurrentTenantIdentifier());

		AuthResponseDto response = authService.handle(request,metaRequest);
		return ResponseEntity.ok(response);
	} catch (Exception e) {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
			.body(AuthResponseDto.builder()
				.token(null)
				.code(0)
				.message(e.getMessage())
				.build());
		}
	}
}
