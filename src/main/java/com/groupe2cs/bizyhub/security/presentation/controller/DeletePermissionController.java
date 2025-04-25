package com.groupe2cs.bizyhub.security.presentation.controller;

	import com.groupe2cs.bizyhub.security.application.mapper.*;
	import com.groupe2cs.bizyhub.security.domain.valueObject.*;
	import com.groupe2cs.bizyhub.security.domain.exception.*;
	import com.groupe2cs.bizyhub.security.application.dto.*;
	import com.groupe2cs.bizyhub.security.application.usecase.*;
	import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;

import com.groupe2cs.bizyhub.security.application.command.DeletePermissionCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

@PreAuthorize("@permissionGate.canDelete(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/permission")
@Tag(name = "Permission commands", description = "Endpoints for managing permissions")
@Slf4j
public class DeletePermissionController {

private final PermissionDeleteApplicationService applicationService;

public DeletePermissionController(PermissionDeleteApplicationService applicationService) {
    this.applicationService = applicationService;
}


@DeleteMapping("/{id}")
@Operation(
summary = "Delete a permission",
description = "Deletes a permission based on the provided identifier"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Permission deleted successfully"),
@ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})
public ResponseEntity<String> deletePermission(
	@Parameter(description = "ID of the permission to delete", required = true)
	@PathVariable String id
	) {
	if (id == null || id.isEmpty()) {
	return ResponseEntity.badRequest().body("Invalid ID");
	}

	try {
	PermissionId idVo = PermissionId.create(id);
	applicationService.deletePermission(idVo);
	return ResponseEntity.ok("Permission deleted successfully");
	} catch (Exception e) {
	log.error("Error deleting permission with id {}: {}", id, e.getMessage());
	return ResponseEntity.internalServerError().body("Error deleting permission");
	}
	}
	}
