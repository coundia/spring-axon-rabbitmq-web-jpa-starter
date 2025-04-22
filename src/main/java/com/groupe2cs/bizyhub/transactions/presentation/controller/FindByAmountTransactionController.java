package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.transactions.application.dto.TransactionResponse;
import com.groupe2cs.bizyhub.transactions.application.usecase.TransactionReadApplicationService;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionAmount;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/queries/transaction")
@Tag(name = "Transaction Queries", description = "Endpoints for querying transactions by amount")
@Slf4j
public class FindByAmountTransactionController {

	private final TransactionReadApplicationService applicationService;

	public FindByAmountTransactionController(TransactionReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@GetMapping("/amount")
	@Operation(
			summary = "Find transaction by amount",
			description = "Returns a list of transactions that match the given amount"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Query successful",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = TransactionResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})

	public ResponseEntity<List<TransactionResponse>> findByAmount(
			@Parameter(description = "Value of the amount to filter by", required = true)
			@RequestParam Double amount
	) {
		try {

			var future = applicationService.findByTransactionAmount(TransactionAmount.create(amount));
			return ResponseEntity.ok(future);
		} catch (Exception e) {
			log.error("Failed to find transaction by amount: {}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
}