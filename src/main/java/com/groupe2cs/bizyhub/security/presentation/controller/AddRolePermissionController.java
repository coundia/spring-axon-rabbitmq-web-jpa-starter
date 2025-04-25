package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.usecase.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

@PreAuthorize("@rolePermissionGate.canCreate(authentication)")

@RestController
@RequestMapping("/api/v1/commands/rolePermission")
@Tag(name = "RolePermission commands", description = "Endpoints for managing rolePermissions")
@Slf4j

public class AddRolePermissionController {

private final RolePermissionCreateApplicationService applicationService;

public AddRolePermissionController(RolePermissionCreateApplicationService applicationService) {
	this.applicationService = applicationService;
}

@PostMapping
@Operation(
summary = "Create a new rolePermission",
description = "Creates a new rolePermission and returns the created entity",
requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
description = "RolePermission request payload",
required = true,
content = @Content(schema = @Schema(implementation = RolePermissionRequest.class))
)
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Successfully created",
content = @Content(schema = @Schema(implementation = RolePermissionResponse.class))),
@ApiResponse(responseCode = "500", description = "Internal server error",
content = @Content(schema = @Schema()))
})
public ResponseEntity<RolePermissionResponse> addRolePermission(@Valid @RequestBody RolePermissionRequest request,
	@AuthenticationPrincipal Jwt jwt) {
	try {

	RolePermissionResponse response =  applicationService.createRolePermission(
	request,
	RequestContext.getUserId(jwt) 
	);

	return ResponseEntity.ok(response);
	} catch (Exception ex) {
	//e.printStackTrace();
	log.error("Failed to create rolePermission: {}", ex.getMessage());
	return ResponseEntity.status(500).build();
	}
}
}
