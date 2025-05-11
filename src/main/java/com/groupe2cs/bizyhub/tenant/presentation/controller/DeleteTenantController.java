package com.groupe2cs.bizyhub.tenant.presentation.controller;

	import com.groupe2cs.bizyhub.tenant.application.mapper.*;
	import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
	import com.groupe2cs.bizyhub.tenant.domain.exception.*;
	import com.groupe2cs.bizyhub.tenant.application.dto.*;
	import com.groupe2cs.bizyhub.tenant.application.usecase.*;
	import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
	import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;

import com.groupe2cs.bizyhub.tenant.application.command.DeleteTenantCommand;
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


@RestController
@RequestMapping("/api/v1/admin/commands/tenant")
@Tag(name = "Tenant commands", description = "Endpoints for managing tenants")
@Slf4j
public class DeleteTenantController {

private final TenantDeleteApplicationService applicationService;

public DeleteTenantController(TenantDeleteApplicationService applicationService) {
    this.applicationService = applicationService;
}


@DeleteMapping("/{id}")
@Operation(
summary = "Delete a tenant",
description = "Deletes a tenant based on the provided identifier"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Tenant deleted successfully"),
@ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})
public ResponseEntity<String> deleteTenant(
	@Parameter(description = "ID of the tenant to delete", required = true)
	@PathVariable String id,
	@AuthenticationPrincipal Jwt jwt
	) {
	if (id == null || id.isEmpty()) {
	return ResponseEntity.badRequest().body("Invalid ID");
	}

	try {
	TenantId idVo = TenantId.create(id);

	MetaRequest metaRequest = MetaRequest.builder()
	.userId(RequestContext.getUserId(jwt))		.tenantId(RequestContext.getTenantId(jwt))
	.build();

	metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

	applicationService.deleteTenant(idVo, metaRequest);

	return ResponseEntity.ok("Tenant deleted successfully");
	} catch (Exception e) {
	log.error("Error deleting tenant with id {}: {}", id, e.getMessage());
	return ResponseEntity.internalServerError().body("Error deleting tenant");
	}
	}
	}
