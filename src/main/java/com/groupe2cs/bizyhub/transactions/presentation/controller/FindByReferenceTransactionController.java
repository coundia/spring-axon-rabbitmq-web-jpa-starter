package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.transactions.application.dto.TransactionResponse;
import com.groupe2cs.bizyhub.transactions.application.usecase.TransactionReadApplicationService;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionReference;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@PreAuthorize("@transactionGate.canRead(authentication, #id)")
@RestController
@RequestMapping("/api/v1/queries/transaction")
@Tag(name = "Transaction Queries", description = "Endpoints for querying transactions by reference")
@Slf4j
public class FindByReferenceTransactionController {

	private final TransactionReadApplicationService applicationService;

	public FindByReferenceTransactionController(TransactionReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@GetMapping("/reference")
	@Operation(
			summary = "Find transaction by reference",
			description = "Returns a list of transactions that match the given reference"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Query successful",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = TransactionResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})

	public ResponseEntity<List<TransactionResponse>> findByReference(
			@Parameter(description = "Value of the reference to filter by", required = true)
			@RequestParam String reference
	) {
		try {

			var future = applicationService.findByTransactionReference(TransactionReference.create(reference));
			return ResponseEntity.ok(future);
		} catch (Exception e) {
			log.error("Failed to find transaction by reference: {}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
}