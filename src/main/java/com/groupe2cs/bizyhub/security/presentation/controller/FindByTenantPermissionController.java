package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.application.usecase.*;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf;
import static org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

@PreAuthorize("@permissionGate.canRead(authentication, #id)")
@RestController
@RequestMapping("/api/v1/queries/permission")
@Tag(name = "Permission Queries", description = "Endpoints for querying permissions by tenant")
@Slf4j
public class FindByTenantPermissionController {

private final PermissionReadApplicationService applicationService;

public FindByTenantPermissionController(PermissionReadApplicationService  applicationService) {
	this.applicationService = applicationService;
}

@GetMapping("/tenant")
@Operation(
summary = "Find permission by tenant",
description = "Returns a list of permissions that match the given tenant"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Query successful",
content = @Content(mediaType = "application/json", schema = @Schema(implementation = PermissionResponse.class))),
@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})

public ResponseEntity<List<PermissionResponse>> findByTenant(
	@Parameter(description = "Value of the tenant to filter by", required = true)
	@RequestParam String tenant
	) {
	try {

	var future = applicationService.findByPermissionTenant(PermissionTenant.create(tenant));
	return ResponseEntity.ok(future);
	} catch (Exception e) {
	log.error("Failed to find permission by tenant: {}", e.getMessage(), e);
	return ResponseEntity.internalServerError().build();
	}
	}
}