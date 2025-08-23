package com.groupe2cs.bizyhub.debts.presentation.controller;

import com.groupe2cs.bizyhub.debts.domain.valueObject.*;
import com.groupe2cs.bizyhub.debts.application.query.*;
import com.groupe2cs.bizyhub.debts.application.mapper.*;
import com.groupe2cs.bizyhub.debts.application.dto.*;
import com.groupe2cs.bizyhub.debts.application.usecase.*;
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


@PreAuthorize("@debtGate.canList(authentication)")
@RestController
@RequestMapping("/api/v1/queries/debt")
@Tag(name = "Debt Queries", description = "Endpoints for querying debts by statuses")
@Slf4j
public class FindByStatusesDebtController {

private final DebtReadApplicationService applicationService;

public FindByStatusesDebtController(DebtReadApplicationService  applicationService) {
	this.applicationService = applicationService;
}

@GetMapping("/statuses")
@Operation(
summary = "Find debt by statuses",
description = "Returns a list of debts that match the given statuses"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Query successful",
content = @Content(mediaType = "application/json", schema = @Schema(implementation = DebtResponse.class))),
@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})

public ResponseEntity<List<DebtResponse>> findByStatuses(
	@AuthenticationPrincipal Jwt jwt,
	@Parameter(description = "Value of the statuses to filter by", required = true)
	@RequestParam String statuses
	) {
	try {

	MetaRequest metaRequest = MetaRequest.builder()
		.userId(RequestContext.getUserId(jwt))		.tenantId(RequestContext.getTenantId(jwt))
	.build();
	metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

	var future = applicationService.findByDebtStatuses(DebtStatuses
	.create(statuses) , metaRequest);

	return ResponseEntity.ok(future);
	} catch (Exception e) {
	log.error("Failed to find debt by statuses: {}", e.getMessage(), e);
	return ResponseEntity.internalServerError().build();
	}
	}
}