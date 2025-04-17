package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.transactions.application.usecase.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.application.mapper.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/commands/transactions")
@Tag(name = "Transactions commands", description = "Endpoints for managing transactionss")
@Slf4j

public class AddTransactionsController {

private final TransactionsCreateApplicationService applicationService;

public AddTransactionsController(TransactionsCreateApplicationService applicationService) {
	this.applicationService = applicationService;
}

@PostMapping
@Operation(
summary = "Create a new transactions",
description = "Creates a new transactions and returns the created entity",
requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
description = "Transactions request payload",
required = true,
content = @Content(schema = @Schema(implementation = TransactionsRequest.class))
)
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Successfully created",
content = @Content(schema = @Schema(implementation = TransactionsResponse.class))),
@ApiResponse(responseCode = "500", description = "Internal server error",
content = @Content(schema = @Schema()))
})
public ResponseEntity<TransactionsResponse> addTransactions(@RequestBody TransactionsRequest request) {
	try {

	TransactionsResponse response =  applicationService.createTransactions(request);

	return ResponseEntity.ok(response);
	} catch (Exception ex) {
	log.error("Failed to create transactions: {}", ex.getMessage());
	return ResponseEntity.status(500).build();
	}
}
}
