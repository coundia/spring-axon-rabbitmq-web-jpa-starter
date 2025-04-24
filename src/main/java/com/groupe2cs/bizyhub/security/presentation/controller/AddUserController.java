package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.UserRequest;
import com.groupe2cs.bizyhub.security.application.dto.UserResponse;
import com.groupe2cs.bizyhub.security.application.usecase.UserCreateApplicationService;
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

@PreAuthorize("@userGate.canCreate(authentication)")

@RestController
@RequestMapping("/api/v1/commands/user")
@Tag(name = "User commands", description = "Endpoints for managing users")
@Slf4j

public class AddUserController {

	private final UserCreateApplicationService applicationService;

	public AddUserController(UserCreateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@PostMapping
	@Operation(
			summary = "Create a new user",
			description = "Creates a new user and returns the created entity",
			requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
					description = "User request payload",
					required = true,
					content = @Content(schema = @Schema(implementation = UserRequest.class))
			)
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully created",
					content = @Content(schema = @Schema(implementation = UserResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content(schema = @Schema()))
	})
	public ResponseEntity<UserResponse> addUser(@Valid @RequestBody UserRequest request,
												@AuthenticationPrincipal Jwt jwt) {
		try {

			UserResponse response = applicationService.createUser(
					request,
					RequestContext.getUserId(jwt)
			);

			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			log.error("Failed to create user: {}", ex.getMessage());
			return ResponseEntity.status(500).build();
		}
	}
}
