package com.groupe2cs.bizyhub.sync.presentation.controller;

import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
import com.groupe2cs.bizyhub.sync.application.query.*;
import com.groupe2cs.bizyhub.sync.application.mapper.*;
import com.groupe2cs.bizyhub.sync.application.dto.*;
import com.groupe2cs.bizyhub.sync.application.usecase.*;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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


@PreAuthorize("@syncStateGate.canList(authentication)")
@RestController
@RequestMapping("/api/v1/queries/syncState")
@Tag(name = "SyncState Queries", description = "Endpoints for querying syncStates by lastCursor")
@Slf4j
public class FindByLastCursorSyncStateController {

private final SyncStateReadApplicationService applicationService;

public FindByLastCursorSyncStateController(SyncStateReadApplicationService  applicationService) {
	this.applicationService = applicationService;
}

@GetMapping("/lastCursor")
@Operation(
summary = "Find syncState by lastCursor",
description = "Returns a list of syncStates that match the given lastCursor"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Query successful",
content = @Content(mediaType = "application/json", schema = @Schema(implementation = SyncStateResponse.class))),
@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})

public ResponseEntity<List<SyncStateResponse>> findByLastCursor(
	@AuthenticationPrincipal Jwt jwt,
	@Parameter(description = "Value of the lastCursor to filter by", required = true)
	@RequestParam String lastCursor
	) {
	try {

	MetaRequest metaRequest = MetaRequest.builder()
		.userId(RequestContext.getUserId(jwt))		.tenantId(RequestContext.getTenantId(jwt))
	.build();
	metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

	var future = applicationService.findBySyncStateLastCursor(SyncStateLastCursor
	.create(lastCursor) , metaRequest);

	return ResponseEntity.ok(future);
	} catch (Exception e) {
	log.error("Failed to find syncState by lastCursor: {}", e.getMessage(), e);
	return ResponseEntity.internalServerError().build();
	}
	}
}