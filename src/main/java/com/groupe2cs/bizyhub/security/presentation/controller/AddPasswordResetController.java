package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.PasswordResetRequest;
import com.groupe2cs.bizyhub.security.application.dto.PasswordResetResponse;
import com.groupe2cs.bizyhub.security.application.usecase.PasswordResetCreateApplicationService;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("@passwordResetGate.canCreate(authentication)")

@RestController
@RequestMapping("/api/v1/commands/passwordReset")
@Tag(name = "PasswordReset commands", description = "Endpoints for managing passwordResets")
@Slf4j

public class AddPasswordResetController {

	private final PasswordResetCreateApplicationService applicationService;

	public AddPasswordResetController(PasswordResetCreateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@PostMapping
	@Operation(
			summary = "Create a new passwordReset",
			description = "Creates a new passwordReset and returns the created entity",
			requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
					description = "PasswordReset request payload",
					required = true,
					content = @Content(schema = @Schema(implementation = PasswordResetRequest.class))
			)
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully created",
					content = @Content(schema = @Schema(implementation = PasswordResetResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content(schema = @Schema()))
	})
	public ResponseEntity<PasswordResetResponse> addPasswordReset(@Valid @RequestBody PasswordResetRequest request,
																  @AuthenticationPrincipal Jwt jwt) {
		try {

			PasswordResetResponse response = applicationService.createPasswordReset(
					request,
					RequestContext.getUserId(jwt)
			);

			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			//e.printStackTrace();
			log.error("Failed to create passwordReset: {}", ex.getMessage());
			return ResponseEntity.status(500).build();
		}
	}
}
