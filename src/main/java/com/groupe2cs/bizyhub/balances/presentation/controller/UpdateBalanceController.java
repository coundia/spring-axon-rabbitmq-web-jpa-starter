package com.groupe2cs.bizyhub.balances.presentation.controller;

import com.groupe2cs.bizyhub.balances.application.dto.BalanceRequest;
import com.groupe2cs.bizyhub.balances.application.dto.BalanceResponse;
import com.groupe2cs.bizyhub.balances.application.usecase.BalanceUpdateApplicationService;
import com.groupe2cs.bizyhub.balances.domain.valueObject.BalanceId;
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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("@balanceGate.canEdit(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/balance")
@Tag(name = "Balance commands", description = "Endpoints for managing balances")
@Slf4j
public class UpdateBalanceController {

	private final BalanceUpdateApplicationService applicationService;

	public UpdateBalanceController(BalanceUpdateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@Operation(summary = "Update a new balance")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Balance Updated",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = BalanceResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content)
	})
	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BalanceResponse> updateBalance(
			@Valid @PathVariable String id,
			@RequestBody BalanceRequest request,
			@AuthenticationPrincipal Jwt jwt
	) {
		{
			try {

				MetaRequest metaRequest = MetaRequest.builder()
						.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
						.build();


				BalanceResponse response = applicationService.updateBalance(BalanceId.create(id),
						request,
						metaRequest
				);

				return ResponseEntity.ok(response);

			} catch (Exception ex) {
				//e.printStackTrace();
				log.error("Failed to Update balance: {}", ex.getMessage(), ex);
				return ResponseEntity.internalServerError().build();
			}
		}
	}
}
