package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.ApiKeyResponse;
import com.groupe2cs.bizyhub.security.application.usecase.ApiKeyReadApplicationService;
import com.groupe2cs.bizyhub.security.domain.valueObject.ApiKeyCreatedAt;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@PreAuthorize("@apiKeyGate.canRead(authentication, #id)")
@RestController
@RequestMapping("/api/v1/queries/apiKey")
@Tag(name = "ApiKey Queries", description = "Endpoints for querying apiKeys by createdAt")
@Slf4j
public class FindByCreatedAtApiKeyController {

	private final ApiKeyReadApplicationService applicationService;

	public FindByCreatedAtApiKeyController(ApiKeyReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@GetMapping("/createdAt")
	@Operation(
			summary = "Find apiKey by createdAt",
			description = "Returns a list of apiKeys that match the given createdAt"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Query successful",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiKeyResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})

	public ResponseEntity<List<ApiKeyResponse>> findByCreatedAt(
			@Parameter(description = "Value of the createdAt to filter by", required = true)
			@RequestParam java.time.Instant createdAt
	) {
		try {

			var future = applicationService.findByApiKeyCreatedAt(ApiKeyCreatedAt.create(createdAt));
			return ResponseEntity.ok(future);
		} catch (Exception e) {
			log.error("Failed to find apiKey by createdAt: {}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
}