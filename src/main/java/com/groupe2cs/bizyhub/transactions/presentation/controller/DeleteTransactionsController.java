package com.groupe2cs.bizyhub.transactions.presentation.controller;

	import com.groupe2cs.bizyhub.transactions.application.mapper.*;
	import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
	import com.groupe2cs.bizyhub.transactions.domain.exception.*;
	import com.groupe2cs.bizyhub.transactions.application.dto.*;
	import com.groupe2cs.bizyhub.transactions.application.usecase.*;

import com.groupe2cs.bizyhub.transactions.application.command.DeleteTransactionsCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/commands/transactions")
@Tag(name = "Transactions commands", description = "Endpoints for managing transactionss")
@Slf4j
public class DeleteTransactionsController {

private final TransactionsDeleteApplicationService applicationService;

public DeleteTransactionsController(TransactionsDeleteApplicationService applicationService) {
    this.applicationService = applicationService;
}


@DeleteMapping("/{id}")
@Operation(
summary = "Delete a transactions",
description = "Deletes a transactions based on the provided identifier"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Transactions deleted successfully"),
@ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})
public ResponseEntity<String> deleteTransactions(
	@Parameter(description = "ID of the transactions to delete", required = true)
	@PathVariable String id
	) {
	if (id == null || id.isEmpty()) {
	return ResponseEntity.badRequest().body("Invalid ID");
	}

	try {
	TransactionsId idVo = TransactionsId.create(id);
	applicationService.deleteTransactions(idVo);
	return ResponseEntity.ok("Transactions deleted successfully");
	} catch (Exception e) {
	log.error("Error deleting transactions with id {}: {}", id, e.getMessage());
	return ResponseEntity.internalServerError().body("Error deleting transactions");
	}
	}
	}
