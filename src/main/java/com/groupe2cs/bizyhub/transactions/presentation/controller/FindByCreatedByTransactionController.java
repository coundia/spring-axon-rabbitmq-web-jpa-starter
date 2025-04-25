package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.transactions.application.query.*;
import com.groupe2cs.bizyhub.transactions.application.mapper.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.application.usecase.*;
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

@PreAuthorize("@transactionGate.canRead(authentication, #id)")
@RestController
@RequestMapping("/api/v1/queries/transaction")
@Tag(name = "Transaction Queries", description = "Endpoints for querying transactions by createdBy")
@Slf4j
public class FindByCreatedByTransactionController {

private final TransactionReadApplicationService applicationService;

public FindByCreatedByTransactionController(TransactionReadApplicationService  applicationService) {
	this.applicationService = applicationService;
}

@GetMapping("/createdBy")
@Operation(
summary = "Find transaction by createdBy",
description = "Returns a list of transactions that match the given createdBy"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Query successful",
content = @Content(mediaType = "application/json", schema = @Schema(implementation = TransactionResponse.class))),
@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})

public ResponseEntity<List<TransactionResponse>> findByCreatedBy(
	@Parameter(description = "Value of the createdBy to filter by", required = true)
	@RequestParam String createdBy
	) {
	try {

	var future = applicationService.findByTransactionCreatedBy(TransactionCreatedBy.create(createdBy));
	return ResponseEntity.ok(future);
	} catch (Exception e) {
	log.error("Failed to find transaction by createdBy: {}", e.getMessage(), e);
	return ResponseEntity.internalServerError().build();
	}
	}
}