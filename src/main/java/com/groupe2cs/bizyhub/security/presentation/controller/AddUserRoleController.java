package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.UserRoleRequest;
import com.groupe2cs.bizyhub.security.application.dto.UserRoleResponse;
import com.groupe2cs.bizyhub.security.application.usecase.UserRoleCreateApplicationService;
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

@PreAuthorize("@userRoleGate.canCreate(authentication)")

@RestController
@RequestMapping("/api/v1/commands/userRole")
@Tag(name = "UserRole commands", description = "Endpoints for managing userRoles")
@Slf4j

public class AddUserRoleController {

	private final UserRoleCreateApplicationService applicationService;

	public AddUserRoleController(UserRoleCreateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@PostMapping
	@Operation(
			summary = "Create a new userRole",
			description = "Creates a new userRole and returns the created entity",
			requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
					description = "UserRole request payload",
					required = true,
					content = @Content(schema = @Schema(implementation = UserRoleRequest.class))
			)
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully created",
					content = @Content(schema = @Schema(implementation = UserRoleResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content(schema = @Schema()))
	})
	public ResponseEntity<UserRoleResponse> addUserRole(@Valid @RequestBody UserRoleRequest request,
														@AuthenticationPrincipal Jwt jwt) {
		try {

			UserRoleResponse response = applicationService.createUserRole(
					request,
					RequestContext.getUserId(jwt)
			);

			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			log.error("Failed to create userRole: {}", ex.getMessage());
			return ResponseEntity.status(500).build();
		}
	}
}
