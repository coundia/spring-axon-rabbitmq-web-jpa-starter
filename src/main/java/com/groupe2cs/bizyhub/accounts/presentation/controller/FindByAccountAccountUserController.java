package com.groupe2cs.bizyhub.accounts.presentation.controller;

import com.groupe2cs.bizyhub.accounts.application.dto.AccountUserResponse;
import com.groupe2cs.bizyhub.accounts.application.usecase.AccountUserReadApplicationService;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.AccountUserAccount;
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


@PreAuthorize("@accountUserGate.canList(authentication)")
@RestController
@RequestMapping("/api/v1/queries/accountUser")
@Tag(name = "AccountUser Queries", description = "Endpoints for querying accountUsers by account")
@Slf4j
public class FindByAccountAccountUserController {

	private final AccountUserReadApplicationService applicationService;

	public FindByAccountAccountUserController(AccountUserReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@GetMapping("/account")
	@Operation(
			summary = "Find accountUser by account",
			description = "Returns a list of accountUsers that match the given account"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Query successful",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = AccountUserResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})

	public ResponseEntity<List<AccountUserResponse>> findByAccount(
			@AuthenticationPrincipal Jwt jwt,
			@Parameter(description = "Value of the account to filter by", required = true)
			@RequestParam String account
	) {
		try {

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
					.build();
			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			var future = applicationService.findByAccountUserAccount(AccountUserAccount
					.create(account), metaRequest);

			return ResponseEntity.ok(future);
		} catch (Exception e) {
			log.error("Failed to find accountUser by account: {}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
}