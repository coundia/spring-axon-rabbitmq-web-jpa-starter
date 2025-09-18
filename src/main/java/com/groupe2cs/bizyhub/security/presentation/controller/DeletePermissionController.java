package com.groupe2cs.bizyhub.security.presentation.controller;

	import com.groupe2cs.bizyhub.security.application.mapper.*;
	import com.groupe2cs.bizyhub.security.domain.valueObject.*;
	import com.groupe2cs.bizyhub.security.domain.exception.*;
	import com.groupe2cs.bizyhub.security.application.dto.*;
	import com.groupe2cs.bizyhub.security.application.usecase.*;
	import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
	import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
	import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;

import com.groupe2cs.bizyhub.security.application.command.DeletePermissionCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;


@PreAuthorize("@permissionGate.canDelete(authentication, #id)")
@RestController
@RequestMapping("/api/v1/admin/commands/permission")
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
}
)
public ResponseEntity<ApiResponseDto> deletePermission(
	@Parameter(description = "ID of the permission to delete", required = true)
	@PathVariable String id,
	@AuthenticationPrincipal Jwt jwt
	) {
	if (id == null || id.isEmpty()) {

	return ResponseEntity.badRequest().body(
	ApiResponseDto.builder()
			.code(0)
			.message("Invalid ID supplied")
			.build()
			);
	}

	try {
	PermissionId idVo = PermissionId.create(id);

	MetaRequest metaRequest = MetaRequest.builder()
	.userId(RequestContext.getUserId(jwt))		.tenantId(RequestContext.getTenantId(jwt))
	.build();

	metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

	applicationService.deletePermission(idVo, metaRequest);

	return ResponseEntity.ok(
	ApiResponseDto.builder()
			.code(1)
			.message("permission with id " + id + " deleted successfully")
			.build()
			);
	} catch (Exception e) {
	log.error("Error deleting permission with id {}: {}", id, e.getMessage());
	return ResponseEntity.internalServerError().body(
	        ApiResponseDto.builder()
                .code(0)
                .message(e.getMessage())
                .build()
			);
	}
	}
	}
