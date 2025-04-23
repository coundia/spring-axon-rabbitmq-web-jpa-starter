package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.ApiKeyRequest;
import com.groupe2cs.bizyhub.security.application.dto.ApiKeyResponse;
import com.groupe2cs.bizyhub.security.application.usecase.ApiKeyUpdateApplicationService;
import com.groupe2cs.bizyhub.security.domain.valueObject.ApiKeyId;
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
import org.springframework.web.bind.annotation.*;

@PreAuthorize("@apiKeyGate.canEdit(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/apiKey")
@Tag(name = "ApiKey commands", description = "Endpoints for managing apiKeys")
@Slf4j
public class UpdateApiKeyController {

	private final ApiKeyUpdateApplicationService applicationService;

	public UpdateApiKeyController(ApiKeyUpdateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@Operation(summary = "Update a new apiKey")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "ApiKey Updated",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = ApiKeyResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content)
	})
	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiKeyResponse> updateApiKey(@Valid @PathVariable String id, @RequestBody ApiKeyRequest request) {
		{
			try {

				ApiKeyResponse response = applicationService.updateApiKey(ApiKeyId.create(id), request);

				return ResponseEntity.ok(response);

			} catch (Exception ex) {
				log.error("Failed to Update apiKey: {}", ex.getMessage(), ex);
				return ResponseEntity.internalServerError().build();
			}
		}
	}
}
