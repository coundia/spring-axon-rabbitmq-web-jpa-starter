package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionSyncRequest;
import com.groupe2cs.bizyhub.transactions.application.usecase.TransactionSyncApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/commands/transaction/sync")
@Tag(name = "Transaction commands", description = "Endpoint to synchronize transactions")
@Slf4j
@RequiredArgsConstructor
public class TransactionSyncController {

	private final TransactionSyncApplicationService applicationService;

	@PostMapping
	@Operation(
			summary = "Sync transactions",
			description = "Initiates synchronization of transaction deltas without blocking the client"
	)
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Sync initiated",
					content = @Content(schema = @Schema(implementation = ApiResponseDto.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content(schema = @Schema()))
	})
	public ResponseEntity<ApiResponseDto> syncTransaction(
			@AuthenticationPrincipal Jwt jwt,
			@Valid @RequestBody TransactionSyncRequest request) {
		try {

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
					.build();

			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			applicationService.syncTransaction(
					request,
					metaRequest
			);
			return ResponseEntity.ok(ApiResponseDto.builder()
					.code(1)
					.message("Sync in progress")
					.build()
			);
		} catch (Exception ex) {

			log.error("Failed to initiate sync of transactions: {}", ex.getMessage());

			return ResponseEntity.status(500)
					.body(ApiResponseDto.builder()
							.code(0)
							.message(ex.getMessage())
							.build()
					);
		}
	}
}
