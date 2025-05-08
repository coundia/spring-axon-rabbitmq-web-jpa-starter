package com.groupe2cs.bizyhub.accounts.presentation.controller;

	import com.groupe2cs.bizyhub.accounts.application.mapper.*;
	import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
	import com.groupe2cs.bizyhub.accounts.domain.exception.*;
	import com.groupe2cs.bizyhub.accounts.application.dto.*;
	import com.groupe2cs.bizyhub.accounts.application.usecase.*;
	import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
	import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;

import com.groupe2cs.bizyhub.accounts.application.command.DeleteAccountCommand;
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


@PreAuthorize("@accountGate.canDelete(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/account")
@Tag(name = "Account commands", description = "Endpoints for managing accounts")
@Slf4j
public class DeleteAccountController {

private final AccountDeleteApplicationService applicationService;

public DeleteAccountController(AccountDeleteApplicationService applicationService) {
    this.applicationService = applicationService;
}


@DeleteMapping("/{id}")
@Operation(
summary = "Delete a account",
description = "Deletes a account based on the provided identifier"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Account deleted successfully"),
@ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})
public ResponseEntity<String> deleteAccount(
	@Parameter(description = "ID of the account to delete", required = true)
	@PathVariable String id,
	@AuthenticationPrincipal Jwt jwt
	) {
	if (id == null || id.isEmpty()) {
	return ResponseEntity.badRequest().body("Invalid ID");
	}

	try {
	AccountId idVo = AccountId.create(id);

	MetaRequest metaRequest = MetaRequest.builder()
	.userId(RequestContext.getUserId(jwt))		.tenantId(RequestContext.getTenantId(jwt))
	.build();

	applicationService.deleteAccount(idVo, metaRequest);

	return ResponseEntity.ok("Account deleted successfully");
	} catch (Exception e) {
	log.error("Error deleting account with id {}: {}", id, e.getMessage());
	return ResponseEntity.internalServerError().body("Error deleting account");
	}
	}
	}
