package com.groupe2cs.bizyhub.balances.presentation.controller;

import com.groupe2cs.bizyhub.balances.application.dto.BalanceRequest;
import com.groupe2cs.bizyhub.balances.application.dto.BalanceResponse;
import com.groupe2cs.bizyhub.balances.application.usecase.BalanceCreateApplicationService;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("@balanceGate.canCreate(authentication)")

@RestController
@RequestMapping("/api/v1/commands/balance")
@Tag(name = "Balance commands", description = "Endpoints for managing balances")
@Slf4j

public class AddBalanceController {

	private final BalanceCreateApplicationService applicationService;

	public AddBalanceController(BalanceCreateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@PostMapping
	@Operation(
			summary = "Create a new balance",
			description = "Creates a new balance and returns the created entity",
			requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
					description = "Balance request payload",
					required = true,
					content = @Content(schema = @Schema(implementation = BalanceRequest.class))
			)
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Successfully created",
					content = @Content(schema = @Schema(implementation = BalanceResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content(schema = @Schema()))
	})
	public ResponseEntity<BalanceResponse> addBalance(@Valid @RequestBody BalanceRequest request,
													  @AuthenticationPrincipal Jwt jwt) {
		try {

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
					.build();

			BalanceResponse response = applicationService.createBalance(
					request,
					metaRequest
			);

			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (Exception ex) {
			//e.printStackTrace();
			log.error("Failed to create balance: {}", ex.getMessage());
			return ResponseEntity.status(500).build();
		}
	}
}
