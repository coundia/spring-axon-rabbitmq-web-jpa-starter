package com.groupe2cs.bizyhub.transactions.presentation.controller;

	import com.groupe2cs.bizyhub.transactions.application.mapper.*;
	import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
	import com.groupe2cs.bizyhub.transactions.domain.exception.*;
	import com.groupe2cs.bizyhub.transactions.application.dto.*;
	import com.groupe2cs.bizyhub.transactions.application.usecase.*;

import com.groupe2cs.bizyhub.transactions.application.command.DeleteTransactionCommand;
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
@RequestMapping("/api/v1/commands/transaction")
@Tag(name = "Transaction commands", description = "Endpoints for managing transactions")
@Slf4j
public class DeleteTransactionController {

private final TransactionDeleteApplicationService applicationService;

public DeleteTransactionController(TransactionDeleteApplicationService applicationService) {
    this.applicationService = applicationService;
}


@DeleteMapping("/{id}")
@Operation(
summary = "Delete a transaction",
description = "Deletes a transaction based on the provided identifier"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Transaction deleted successfully"),
@ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})
public ResponseEntity<String> deleteTransaction(
	@Parameter(description = "ID of the transaction to delete", required = true)
	@PathVariable String id
	) {
	if (id == null || id.isEmpty()) {
	return ResponseEntity.badRequest().body("Invalid ID");
	}

	try {
	TransactionId idVo = TransactionId.create(id);
	applicationService.deleteTransaction(idVo);
	return ResponseEntity.ok("Transaction deleted successfully");
	} catch (Exception e) {
	log.error("Error deleting transaction with id {}: {}", id, e.getMessage());
	return ResponseEntity.internalServerError().body("Error deleting transaction");
	}
	}
	}
