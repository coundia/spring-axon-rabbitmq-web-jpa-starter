package com.groupe2cs.bizyhub.tenant.presentation.controller;

import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
import com.groupe2cs.bizyhub.tenant.application.query.*;
import com.groupe2cs.bizyhub.tenant.application.mapper.*;
import com.groupe2cs.bizyhub.tenant.application.dto.*;
import com.groupe2cs.bizyhub.tenant.application.usecase.*;
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

@RestController
@RequestMapping("/api/v1/queries/tenant")
@Tag(name = "Tenant Queries", description = "Endpoints for querying tenants by name")
@Slf4j
public class FindByNameTenantController {

private final TenantReadApplicationService applicationService;

public FindByNameTenantController(TenantReadApplicationService  applicationService) {
	this.applicationService = applicationService;
}

@GetMapping("/name")
@Operation(
summary = "Find tenant by name",
description = "Returns a list of tenants that match the given name"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Query successful",
content = @Content(mediaType = "application/json", schema = @Schema(implementation = TenantResponse.class))),
@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})

public ResponseEntity<List<TenantResponse>> findByName(
	@Parameter(description = "Value of the name to filter by", required = true)
	@RequestParam String name
	) {
	try {

	var future = applicationService.findByTenantName(TenantName.create(name));
	return ResponseEntity.ok(future);
	} catch (Exception e) {
	log.error("Failed to find tenant by name: {}", e.getMessage(), e);
	return ResponseEntity.internalServerError().build();
	}
	}
}