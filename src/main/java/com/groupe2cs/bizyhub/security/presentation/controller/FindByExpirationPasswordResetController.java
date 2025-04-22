package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.PasswordResetResponse;
import com.groupe2cs.bizyhub.security.application.usecase.PasswordResetReadApplicationService;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetExpiration;
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

@PreAuthorize("@passwordResetGate.canRead(authentication, #id)")
@RestController
@RequestMapping("/api/v1/queries/passwordReset")
@Tag(name = "PasswordReset Queries", description = "Endpoints for querying passwordResets by expiration")
@Slf4j
public class FindByExpirationPasswordResetController {

	private final PasswordResetReadApplicationService applicationService;

	public FindByExpirationPasswordResetController(PasswordResetReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@GetMapping("/expiration")
	@Operation(
			summary = "Find passwordReset by expiration",
			description = "Returns a list of passwordResets that match the given expiration"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Query successful",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = PasswordResetResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})

	public ResponseEntity<List<PasswordResetResponse>> findByExpiration(
			@Parameter(description = "Value of the expiration to filter by", required = true)
			@RequestParam java.time.Instant expiration
	) {
		try {

			var future = applicationService.findByPasswordResetExpiration(PasswordResetExpiration.create(expiration));
			return ResponseEntity.ok(future);
		} catch (Exception e) {
			log.error("Failed to find passwordReset by expiration: {}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
}