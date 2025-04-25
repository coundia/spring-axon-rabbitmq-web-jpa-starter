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
@Tag(name = "Tenant Queries", description = "Endpoints for querying tenants by id")
@Slf4j
public class FindByIdTenantController {

private final TenantReadApplicationService applicationService;

public FindByIdTenantController(TenantReadApplicationService  applicationService) {
	this.applicationService = applicationService;
}

@GetMapping("/id")
@Operation(
summary = "Find tenant by id",
description = "Returns a single tenants that match the given id"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Query successful",
content = @Content(mediaType = "application/json", schema = @Schema(implementation = TenantResponse.class))),
@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})

public ResponseEntity<TenantResponse> findById(
	@Parameter(description = "Value of the id to filter by", required = true)
	@RequestParam String id
	) {
	try {

	var future = applicationService.findByTenantId(TenantId.create(id));
	return ResponseEntity.ok(future);
	} catch (Exception e) {
	log.error("Failed to find tenant by id: {}", e.getMessage(), e);
	return ResponseEntity.internalServerError().build();
	}
	}
}