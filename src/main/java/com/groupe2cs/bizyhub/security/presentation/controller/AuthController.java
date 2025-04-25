package com.groupe2cs.bizyhub.security.presentation.controller;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.application.service.*;

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

@Tag(name = "Auth", description = "Endpoints for authentication")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

private final AuthenticationManager authenticationManager;
private final JwtService jwtService;

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
public ResponseEntity<AuthResponseDto> authenticate(@org.springframework.web.bind.annotation.RequestBody AuthRequestDto request) {
	try {

	Authentication authentication = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
	);

	String token = jwtService.generateToken(authentication);

	return ResponseEntity.ok(
	AuthResponseDto.builder()
	.token(token)
	.username(authentication.getName())
	.expirationAt(jwtService.extractExpiration(token))
	.code(1)
	.message("Login successful")
	.build()
	);
	} catch (Exception e) {
	e.printStackTrace();
	return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	.body(AuthResponseDto.builder()
	.token(null)
	.code(0)
	.message("Unauthorized")
	.build());
	}
	}
	}
