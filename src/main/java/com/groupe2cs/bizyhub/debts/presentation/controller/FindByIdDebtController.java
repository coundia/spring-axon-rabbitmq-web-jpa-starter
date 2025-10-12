package com.groupe2cs.bizyhub.debts.presentation.controller;

import com.groupe2cs.bizyhub.debts.application.dto.DebtResponse;
import com.groupe2cs.bizyhub.debts.application.usecase.DebtReadApplicationService;
import com.groupe2cs.bizyhub.debts.domain.valueObject.DebtId;
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


@PreAuthorize("@debtGate.canRead(authentication, #id)")
@RestController
@RequestMapping("/api/v1/queries/debt")
@Tag(name = "Debt Queries", description = "Endpoints for querying debts by id")
@Slf4j
public class FindByIdDebtController {

	private final DebtReadApplicationService applicationService;

	public FindByIdDebtController(DebtReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@GetMapping("/id")
	@Operation(
			summary = "Find debt by id",
			description = "Returns a single debts that match the given id"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Query successful",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = DebtResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})

	public ResponseEntity<DebtResponse> findById(
			@AuthenticationPrincipal Jwt jwt,
			@Parameter(description = "Value of the id to filter by", required = true)
			@RequestParam String id
	) {
		try {

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
					.build();
			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			var future = applicationService.findByDebtId(DebtId
					.create(id), metaRequest);

			return ResponseEntity.ok(future);
		} catch (Exception e) {
			log.error("Failed to find debt by id: {}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
}