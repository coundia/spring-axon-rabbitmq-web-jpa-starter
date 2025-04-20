package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.usecase.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/commands/rolepermission")
@Tag(name = "RolePermission commands", description = "Endpoints for managing rolepermissions")
@Slf4j

public class AddRolePermissionController {

private final RolePermissionCreateApplicationService applicationService;

public AddRolePermissionController(RolePermissionCreateApplicationService applicationService) {
	this.applicationService = applicationService;
}

@PostMapping
@Operation(
summary = "Create a new rolepermission",
description = "Creates a new rolepermission and returns the created entity",
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
public ResponseEntity<RolePermissionResponse> addRolePermission(@RequestBody RolePermissionRequest request) {
	try {

	RolePermissionResponse response =  applicationService.createRolePermission(request);

	return ResponseEntity.ok(response);
	} catch (Exception ex) {
	log.error("Failed to create rolepermission: {}", ex.getMessage());
	return ResponseEntity.status(500).build();
	}
}
}
