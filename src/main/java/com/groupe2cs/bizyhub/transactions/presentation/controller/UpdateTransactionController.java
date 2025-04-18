package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.transactions.application.dto.TransactionRequest;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionResponse;
import com.groupe2cs.bizyhub.transactions.application.usecase.TransactionUpdateApplicationService;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/commands/transaction")
@Tag(name = "Transaction commands", description = "Endpoints for managing transactions")
@Slf4j
public class UpdateTransactionController {

	private final TransactionUpdateApplicationService applicationService;

	public UpdateTransactionController(TransactionUpdateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@Operation(summary = "Update a new transaction")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Transaction Updated",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = TransactionResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content)
	})
	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionResponse> updateTransaction(@PathVariable String id, @RequestBody TransactionRequest request) {
		{
			try {

				TransactionResponse response = applicationService.updateTransaction(TransactionId.create(id), request);

				return ResponseEntity.ok(response);

			} catch (Exception ex) {
				log.error("Failed to Update transaction: {}", ex.getMessage(), ex);
				return ResponseEntity.internalServerError().build();
			}
		}
	}
}
