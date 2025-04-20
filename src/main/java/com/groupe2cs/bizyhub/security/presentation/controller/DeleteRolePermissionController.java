package com.groupe2cs.bizyhub.security.presentation.controller;

	import com.groupe2cs.bizyhub.security.application.mapper.*;
	import com.groupe2cs.bizyhub.security.domain.valueObject.*;
	import com.groupe2cs.bizyhub.security.domain.exception.*;
	import com.groupe2cs.bizyhub.security.application.dto.*;
	import com.groupe2cs.bizyhub.security.application.usecase.*;

import com.groupe2cs.bizyhub.security.application.command.DeleteRolePermissionCommand;
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

@RestController
@RequestMapping("/api/v1/commands/rolepermission")
@Tag(name = "RolePermission commands", description = "Endpoints for managing rolepermissions")
@Slf4j
public class DeleteRolePermissionController {

private final RolePermissionDeleteApplicationService applicationService;

public DeleteRolePermissionController(RolePermissionDeleteApplicationService applicationService) {
    this.applicationService = applicationService;
}


@DeleteMapping("/{id}")
@Operation(
summary = "Delete a rolepermission",
description = "Deletes a rolepermission based on the provided identifier"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "RolePermission deleted successfully"),
@ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})
public ResponseEntity<String> deleteRolePermission(
	@Parameter(description = "ID of the rolepermission to delete", required = true)
	@PathVariable String id
	) {
	if (id == null || id.isEmpty()) {
	return ResponseEntity.badRequest().body("Invalid ID");
	}

	try {
	RolePermissionId idVo = RolePermissionId.create(id);
	applicationService.deleteRolePermission(idVo);
	return ResponseEntity.ok("RolePermission deleted successfully");
	} catch (Exception e) {
	log.error("Error deleting rolepermission with id {}: {}", id, e.getMessage());
	return ResponseEntity.internalServerError().body("Error deleting rolepermission");
	}
	}
	}
