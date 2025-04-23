package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.usecase.ApiKeyDeleteApplicationService;
import com.groupe2cs.bizyhub.security.domain.valueObject.ApiKeyId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("@apiKeyGate.canDelete(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/apiKey")
@Tag(name = "ApiKey commands", description = "Endpoints for managing apiKeys")
@Slf4j
public class DeleteApiKeyController {

	private final ApiKeyDeleteApplicationService applicationService;

	public DeleteApiKeyController(ApiKeyDeleteApplicationService applicationService) {
		this.applicationService = applicationService;
	}


	@DeleteMapping("/{id}")
	@Operation(
			summary = "Delete a apiKey",
			description = "Deletes a apiKey based on the provided identifier"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "ApiKey deleted successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})
	public ResponseEntity<String> deleteApiKey(
			@Parameter(description = "ID of the apiKey to delete", required = true)
			@PathVariable String id
	) {
		if (id == null || id.isEmpty()) {
			return ResponseEntity.badRequest().body("Invalid ID");
		}

		try {
			ApiKeyId idVo = ApiKeyId.create(id);
			applicationService.deleteApiKey(idVo);
			return ResponseEntity.ok("ApiKey deleted successfully");
		} catch (Exception e) {
			log.error("Error deleting apiKey with id {}: {}", id, e.getMessage());
			return ResponseEntity.internalServerError().body("Error deleting apiKey");
		}
	}
}
