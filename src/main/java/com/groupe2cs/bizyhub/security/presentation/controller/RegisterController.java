package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.AuthRequestDto;
import com.groupe2cs.bizyhub.security.application.dto.AuthResponseDto;
import com.groupe2cs.bizyhub.security.application.service.RegisterUser;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Auth", description = "Endpoints registration")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class RegisterController {

	private final RegisterUser registerUser;
	private final CurrentTenantIdentifierResolver currentTenantIdentifierResolver;

	@PostMapping("/register")
	@Operation(
			summary = "Register a new user",
			description = "Creates a new user account with username and password",
			requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
					description = "Registration credentials",
					required = true,
					content = @Content(schema = @Schema(implementation = AuthRequestDto.class))
			)
	)
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "User registered successfully",
					content = @Content(schema = @Schema(implementation = AuthResponseDto.class))
			),
			@ApiResponse(
					responseCode = "400",
					description = "Invalid request or user already exists",
					content = @Content(schema = @Schema(implementation = AuthResponseDto.class))
			)
	})
	public ResponseEntity<AuthResponseDto> register(@RequestBody AuthRequestDto request) {
		try {

			MetaRequest metaRequest = new MetaRequest();

			metaRequest.setTenantId(currentTenantIdentifierResolver.resolveCurrentTenantIdentifier());
			return ResponseEntity.ok(
					registerUser.handle(
							request,
							metaRequest
					)
			);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(AuthResponseDto.builder()
							.token(null)
							.code(0)
							.message(e.getMessage())
							.build());
		}
	}
}
