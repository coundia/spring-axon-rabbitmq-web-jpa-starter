package com.groupe2cs.bizyhub.transactions.presentation.controller;

	import com.groupe2cs.bizyhub.transactions.application.mapper.*;
	import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
	import com.groupe2cs.bizyhub.transactions.domain.exception.*;
	import com.groupe2cs.bizyhub.transactions.application.dto.*;
	import com.groupe2cs.bizyhub.transactions.application.usecase.*;
	import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
	import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
	import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;

import com.groupe2cs.bizyhub.transactions.application.command.DeleteTransactionItemCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;


@PreAuthorize("@transactionItemGate.canDelete(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/transactionItem")
@Tag(name = "TransactionItem commands", description = "Endpoints for managing transactionItems")
@Slf4j
public class DeleteTransactionItemController {

private final TransactionItemDeleteApplicationService applicationService;

public DeleteTransactionItemController(TransactionItemDeleteApplicationService applicationService) {
    this.applicationService = applicationService;
}


@DeleteMapping("/{id}")
@Operation(
summary = "Delete a transactionItem",
description = "Deletes a transactionItem based on the provided identifier"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "TransactionItem deleted successfully"),
@ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
}
)
public ResponseEntity<ApiResponseDto> deleteTransactionItem(
	@Parameter(description = "ID of the transactionItem to delete", required = true)
	@PathVariable String id,
	@AuthenticationPrincipal Jwt jwt
	) {
	if (id == null || id.isEmpty()) {

	return ResponseEntity.badRequest().body(
	ApiResponseDto.builder()
			.code(0)
			.message("Invalid ID supplied")
			.build()
			);
	}

	try {
	TransactionItemId idVo = TransactionItemId.create(id);

	MetaRequest metaRequest = MetaRequest.builder()
	.userId(RequestContext.getUserId(jwt))		.tenantId(RequestContext.getTenantId(jwt))
	.build();

	metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

	applicationService.deleteTransactionItem(idVo, metaRequest);

	return ResponseEntity.ok(
	ApiResponseDto.builder()
			.code(1)
			.message("transactionItem with id " + id + " deleted successfully")
			.build()
			);
	} catch (Exception e) {
	log.error("Error deleting transactionItem with id {}: {}", id, e.getMessage());
	return ResponseEntity.internalServerError().body(
	        ApiResponseDto.builder()
                .code(0)
                .message(e.getMessage())
                .build()
			);
	}
	}
	}
