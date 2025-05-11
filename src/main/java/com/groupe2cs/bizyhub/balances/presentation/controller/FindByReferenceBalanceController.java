package com.groupe2cs.bizyhub.balances.presentation.controller;

import com.groupe2cs.bizyhub.balances.domain.valueObject.*;
import com.groupe2cs.bizyhub.balances.application.query.*;
import com.groupe2cs.bizyhub.balances.application.mapper.*;
import com.groupe2cs.bizyhub.balances.application.dto.*;
import com.groupe2cs.bizyhub.balances.application.usecase.*;
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


@PreAuthorize("@balanceGate.canList(authentication)")
@RestController
@RequestMapping("/api/v1/queries/balance")
@Tag(name = "Balance Queries", description = "Endpoints for querying balances by reference")
@Slf4j
public class FindByReferenceBalanceController {

private final BalanceReadApplicationService applicationService;

public FindByReferenceBalanceController(BalanceReadApplicationService  applicationService) {
	this.applicationService = applicationService;
}

@GetMapping("/reference")
@Operation(
summary = "Find balance by reference",
description = "Returns a list of balances that match the given reference"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Query successful",
content = @Content(mediaType = "application/json", schema = @Schema(implementation = BalanceResponse.class))),
@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})

public ResponseEntity<List<BalanceResponse>> findByReference(
	@AuthenticationPrincipal Jwt jwt,
	@Parameter(description = "Value of the reference to filter by", required = true)
	@RequestParam String reference
	) {
	try {

	MetaRequest metaRequest = MetaRequest.builder()
		.userId(RequestContext.getUserId(jwt))		.tenantId(RequestContext.getTenantId(jwt))
	.build();

	var future = applicationService.findByBalanceReference(BalanceReference
	.create(reference) , metaRequest);

	return ResponseEntity.ok(future);
	} catch (Exception e) {
	log.error("Failed to find balance by reference: {}", e.getMessage(), e);
	return ResponseEntity.internalServerError().build();
	}
	}
}