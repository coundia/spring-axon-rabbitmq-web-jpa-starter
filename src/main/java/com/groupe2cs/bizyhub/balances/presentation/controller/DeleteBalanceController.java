package com.groupe2cs.bizyhub.balances.presentation.controller;

	import com.groupe2cs.bizyhub.balances.application.mapper.*;
	import com.groupe2cs.bizyhub.balances.domain.valueObject.*;
	import com.groupe2cs.bizyhub.balances.domain.exception.*;
	import com.groupe2cs.bizyhub.balances.application.dto.*;
	import com.groupe2cs.bizyhub.balances.application.usecase.*;
	import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
	import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;

import com.groupe2cs.bizyhub.balances.application.command.DeleteBalanceCommand;
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


@PreAuthorize("@balanceGate.canDelete(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/balance")
@Tag(name = "Balance commands", description = "Endpoints for managing balances")
@Slf4j
public class DeleteBalanceController {

private final BalanceDeleteApplicationService applicationService;

public DeleteBalanceController(BalanceDeleteApplicationService applicationService) {
    this.applicationService = applicationService;
}


@DeleteMapping("/{id}")
@Operation(
summary = "Delete a balance",
description = "Deletes a balance based on the provided identifier"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Balance deleted successfully"),
@ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})
public ResponseEntity<String> deleteBalance(
	@Parameter(description = "ID of the balance to delete", required = true)
	@PathVariable String id,
	@AuthenticationPrincipal Jwt jwt
	) {
	if (id == null || id.isEmpty()) {
	return ResponseEntity.badRequest().body("Invalid ID");
	}

	try {
	BalanceId idVo = BalanceId.create(id);

	MetaRequest metaRequest = MetaRequest.builder()
	.userId(RequestContext.getUserId(jwt))		.tenantId(RequestContext.getTenantId(jwt))
	.build();

	applicationService.deleteBalance(idVo, metaRequest);

	return ResponseEntity.ok("Balance deleted successfully");
	} catch (Exception e) {
	log.error("Error deleting balance with id {}: {}", id, e.getMessage());
	return ResponseEntity.internalServerError().body("Error deleting balance");
	}
	}
	}
