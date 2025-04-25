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

@PreAuthorize("@apiKeyGate.canRead(authentication, #id)")
@RestController
@RequestMapping("/api/v1/queries/apiKey")
@Tag(name = "ApiKey Queries", description = "Endpoints for querying apiKeys by id")
@Slf4j
public class FindByIdApiKeyController {

private final ApiKeyReadApplicationService applicationService;

public FindByIdApiKeyController(ApiKeyReadApplicationService  applicationService) {
	this.applicationService = applicationService;
}

@GetMapping("/id")
@Operation(
summary = "Find apiKey by id",
description = "Returns a single apiKeys that match the given id"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Query successful",
content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiKeyResponse.class))),
@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})

public ResponseEntity<ApiKeyResponse> findById(
	@Parameter(description = "Value of the id to filter by", required = true)
	@RequestParam String id
	) {
	try {

	var future = applicationService.findByApiKeyId(ApiKeyId.create(id));
	return ResponseEntity.ok(future);
	} catch (Exception e) {
	log.error("Failed to find apiKey by id: {}", e.getMessage(), e);
	return ResponseEntity.internalServerError().build();
	}
	}
}