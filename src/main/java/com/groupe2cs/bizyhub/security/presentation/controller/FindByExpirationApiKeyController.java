package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.ApiKeyResponse;
import com.groupe2cs.bizyhub.security.application.usecase.ApiKeyReadApplicationService;
import com.groupe2cs.bizyhub.security.domain.valueObject.ApiKeyExpiration;
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

@PreAuthorize("@apiKeyGate.canRead(authentication, #id)")
@RestController
@RequestMapping("/api/v1/admin/queries/apiKey")
@Tag(name = "ApiKey Queries", description = "Endpoints for querying apiKeys by expiration")
@Slf4j
public class FindByExpirationApiKeyController {

	private final ApiKeyReadApplicationService applicationService;

	public FindByExpirationApiKeyController(ApiKeyReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@GetMapping("/expiration")
	@Operation(
			summary = "Find apiKey by expiration",
			description = "Returns a list of apiKeys that match the given expiration"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Query successful",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiKeyResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})

	public ResponseEntity<List<ApiKeyResponse>> findByExpiration(
			@AuthenticationPrincipal Jwt jwt,
			@Parameter(description = "Value of the expiration to filter by", required = true)
			@RequestParam java.time.Instant expiration
	) {
		try {

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
					.build();

			var future = applicationService.findByApiKeyExpiration(ApiKeyExpiration
					.create(expiration), metaRequest);

			return ResponseEntity.ok(future);
		} catch (Exception e) {
			log.error("Failed to find apiKey by expiration: {}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
}