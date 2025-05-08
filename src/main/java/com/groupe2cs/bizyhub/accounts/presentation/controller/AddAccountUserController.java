package com.groupe2cs.bizyhub.accounts.presentation.controller;

import com.groupe2cs.bizyhub.accounts.application.usecase.*;
import com.groupe2cs.bizyhub.accounts.application.dto.*;
import com.groupe2cs.bizyhub.accounts.application.mapper.*;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

@PreAuthorize("@accountUserGate.canCreate(authentication)")

@RestController
@RequestMapping("/api/v1/commands/accountUser")
@Tag(name = "AccountUser commands", description = "Endpoints for managing accountUsers")
@Slf4j

public class AddAccountUserController {

private final AccountUserCreateApplicationService applicationService;

public AddAccountUserController(AccountUserCreateApplicationService applicationService) {
	this.applicationService = applicationService;
}

@PostMapping
@Operation(
summary = "Create a new accountUser",
description = "Creates a new accountUser and returns the created entity",
requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
description = "AccountUser request payload",
required = true,
content = @Content(schema = @Schema(implementation = AccountUserRequest.class))
)
)
@ApiResponses(value = {
@ApiResponse(responseCode = "201", description = "Successfully created",
content = @Content(schema = @Schema(implementation = AccountUserResponse.class))),
@ApiResponse(responseCode = "500", description = "Internal server error",
content = @Content(schema = @Schema()))
})
public ResponseEntity<AccountUserResponse> addAccountUser(@Valid @RequestBody AccountUserRequest request,
	@AuthenticationPrincipal Jwt jwt) {
	try {

	MetaRequest metaRequest = MetaRequest.builder()
		.userId(RequestContext.getUserId(jwt))		.tenantId(RequestContext.getTenantId(jwt))
		.build();

	AccountUserResponse response =  applicationService.createAccountUser(
			request,
			metaRequest
	);

	return ResponseEntity.status(HttpStatus.CREATED).body(response);
	} catch (Exception ex) {
	//e.printStackTrace();
	log.error("Failed to create accountUser: {}", ex.getMessage());
	return ResponseEntity.status(500).build();
	}
}
}
