package com.groupe2cs.bizyhub.balances.presentation.controller;

import com.groupe2cs.bizyhub.balances.application.dto.BalanceResponse;
import com.groupe2cs.bizyhub.balances.application.usecase.BalanceReadApplicationService;
import com.groupe2cs.bizyhub.balances.domain.valueObject.BalanceCurrency;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@PreAuthorize("@balanceGate.canRead(authentication, #id)")
@RestController
@RequestMapping("/api/v1/queries/balance")
@Tag(name = "Balance Queries", description = "Endpoints for querying balances by currency")
@Slf4j
public class FindByCurrencyBalanceController {

	private final BalanceReadApplicationService applicationService;

	public FindByCurrencyBalanceController(BalanceReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@GetMapping("/currency")
	@Operation(
			summary = "Find balance by currency",
			description = "Returns a list of balances that match the given currency"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Query successful",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = BalanceResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})

	public ResponseEntity<List<BalanceResponse>> findByCurrency(
			@AuthenticationPrincipal Jwt jwt,
			@Parameter(description = "Value of the currency to filter by", required = true)
			@RequestParam String currency
	) {
		try {

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
					.build();

			var future = applicationService.findByBalanceCurrency(BalanceCurrency
					.create(currency), metaRequest);

			return ResponseEntity.ok(future);
		} catch (Exception e) {
			log.error("Failed to find balance by currency: {}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
}