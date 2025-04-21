package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.transactions.application.dto.TransactionRequest;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionResponse;
import com.groupe2cs.bizyhub.transactions.application.usecase.TransactionCreateApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("@transactionGate.canCreate(authentication)")

@RestController
@RequestMapping("/api/v1/commands/transaction")
@Tag(name = "Transaction commands", description = "Endpoints for managing transactions")
@Slf4j

public class AddTransactionController {

	private final TransactionCreateApplicationService applicationService;

	public AddTransactionController(TransactionCreateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@PostMapping
	@Operation(
			summary = "Create a new transaction",
			description = "Creates a new transaction and returns the created entity",
			requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
					description = "Transaction request payload",
					required = true,
					content = @Content(schema = @Schema(implementation = TransactionRequest.class))
			)
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully created",
					content = @Content(schema = @Schema(implementation = TransactionResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content(schema = @Schema()))
	})
	public ResponseEntity<TransactionResponse> addTransaction(@Valid @RequestBody TransactionRequest request) {
		try {

			TransactionResponse response = applicationService.createTransaction(request);

			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			log.error("Failed to create transaction: {}", ex.getMessage());
			return ResponseEntity.status(500).build();
		}
	}
}
