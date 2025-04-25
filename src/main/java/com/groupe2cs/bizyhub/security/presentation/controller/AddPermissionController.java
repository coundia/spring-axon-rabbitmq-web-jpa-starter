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

@PreAuthorize("@permissionGate.canCreate(authentication)")

@RestController
@RequestMapping("/api/v1/commands/permission")
@Tag(name = "Permission commands", description = "Endpoints for managing permissions")
@Slf4j

public class AddPermissionController {

private final PermissionCreateApplicationService applicationService;

public AddPermissionController(PermissionCreateApplicationService applicationService) {
	this.applicationService = applicationService;
}

@PostMapping
@Operation(
summary = "Create a new permission",
description = "Creates a new permission and returns the created entity",
requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
description = "Permission request payload",
required = true,
content = @Content(schema = @Schema(implementation = PermissionRequest.class))
)
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Successfully created",
content = @Content(schema = @Schema(implementation = PermissionResponse.class))),
@ApiResponse(responseCode = "500", description = "Internal server error",
content = @Content(schema = @Schema()))
})
public ResponseEntity<PermissionResponse> addPermission(@Valid @RequestBody PermissionRequest request,
	@AuthenticationPrincipal Jwt jwt) {
	try {

	PermissionResponse response =  applicationService.createPermission(
	request,
	RequestContext.getUserId(jwt) 
	);

	return ResponseEntity.ok(response);
	} catch (Exception ex) {
	//e.printStackTrace();
	log.error("Failed to create permission: {}", ex.getMessage());
	return ResponseEntity.status(500).build();
	}
}
}
