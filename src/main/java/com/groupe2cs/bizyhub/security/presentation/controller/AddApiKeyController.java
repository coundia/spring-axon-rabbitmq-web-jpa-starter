package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.usecase.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
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

@PreAuthorize("@apiKeyGate.canCreate(authentication)")

@RestController
@RequestMapping("/api/v1/commands/apiKey")
@Tag(name = "ApiKey commands", description = "Endpoints for managing apiKeys")
@Slf4j

public class AddApiKeyController {

private final ApiKeyCreateApplicationService applicationService;

public AddApiKeyController(ApiKeyCreateApplicationService applicationService) {
	this.applicationService = applicationService;
}

@PostMapping
@Operation(
summary = "Create a new apiKey",
description = "Creates a new apiKey and returns the created entity",
requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
description = "ApiKey request payload",
required = true,
content = @Content(schema = @Schema(implementation = ApiKeyRequest.class))
)
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Successfully created",
content = @Content(schema = @Schema(implementation = ApiKeyResponse.class))),
@ApiResponse(responseCode = "500", description = "Internal server error",
content = @Content(schema = @Schema()))
})
public ResponseEntity<ApiKeyResponse> addApiKey(@Valid @RequestBody ApiKeyRequest request,
	@AuthenticationPrincipal Jwt jwt) {
	try {

	ApiKeyResponse response =  applicationService.createApiKey(
	request,
	RequestContext.getUserId(jwt) 
	);

	return ResponseEntity.ok(response);
	} catch (Exception ex) {
	//e.printStackTrace();
	log.error("Failed to create apiKey: {}", ex.getMessage());
	return ResponseEntity.status(500).build();
	}
}
}
