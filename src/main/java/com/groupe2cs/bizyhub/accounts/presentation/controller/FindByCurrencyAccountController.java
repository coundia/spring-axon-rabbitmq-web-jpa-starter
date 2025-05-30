package com.groupe2cs.bizyhub.accounts.presentation.controller;

import com.groupe2cs.bizyhub.accounts.application.dto.AccountResponse;
import com.groupe2cs.bizyhub.accounts.application.usecase.AccountReadApplicationService;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.AccountCurrency;
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


@PreAuthorize("@accountGate.canList(authentication)")
@RestController
@RequestMapping("/api/v1/queries/account")
@Tag(name = "Account Queries", description = "Endpoints for querying accounts by currency")
@Slf4j
public class FindByCurrencyAccountController {

	private final AccountReadApplicationService applicationService;

	public FindByCurrencyAccountController(AccountReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@GetMapping("/currency")
	@Operation(
			summary = "Find account by currency",
			description = "Returns a list of accounts that match the given currency"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Query successful",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = AccountResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})

	public ResponseEntity<List<AccountResponse>> findByCurrency(
			@AuthenticationPrincipal Jwt jwt,
			@Parameter(description = "Value of the currency to filter by", required = true)
			@RequestParam String currency
	) {
		try {

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
					.build();
			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			var future = applicationService.findByAccountCurrency(AccountCurrency
					.create(currency), metaRequest);

			return ResponseEntity.ok(future);
		} catch (Exception e) {
			log.error("Failed to find account by currency: {}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
}