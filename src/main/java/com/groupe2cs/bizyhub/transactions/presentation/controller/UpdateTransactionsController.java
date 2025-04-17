package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.transactions.application.usecase.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.application.mapper.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/commands/transactions")
@Tag(name = "Transactions commands", description = "Endpoints for managing transactionss")
@Slf4j
public class UpdateTransactionsController {

private final TransactionsUpdateApplicationService applicationService;

public UpdateTransactionsController(TransactionsUpdateApplicationService  applicationService) {
this.applicationService = applicationService;
}

@Operation(summary = "Update a new transactions")
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Transactions Updated",
content = @Content(mediaType = "application/json",
schema = @Schema(implementation = TransactionsResponse.class))),
@ApiResponse(responseCode = "500", description = "Internal server error",
content = @Content)
})
@PutMapping(value="{id}",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<TransactionsResponse> updateTransactions(@PathVariable String id, @RequestBody TransactionsRequest request) { {
	try {

	TransactionsResponse response = applicationService.updateTransactions(TransactionsId.create(id), request);

	return ResponseEntity.ok(response);

	} catch (Exception ex) {
	log.error("Failed to Update transactions: {}", ex.getMessage(), ex);
	return ResponseEntity.internalServerError().build();
	}
	}
}
}
