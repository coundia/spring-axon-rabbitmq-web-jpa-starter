package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.PasswordResetRequest;
import com.groupe2cs.bizyhub.security.application.dto.PasswordResetResponse;
import com.groupe2cs.bizyhub.security.application.usecase.PasswordResetUpdateApplicationService;
import com.groupe2cs.bizyhub.security.domain.valueObject.PasswordResetId;
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

@PreAuthorize("@passwordResetGate.canEdit(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/passwordReset")
@Tag(name = "PasswordReset commands", description = "Endpoints for managing passwordResets")
@Slf4j
public class UpdatePasswordResetController {

	private final PasswordResetUpdateApplicationService applicationService;

	public UpdatePasswordResetController(PasswordResetUpdateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@Operation(summary = "Update a new passwordReset")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "PasswordReset Updated",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = PasswordResetResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content)
	})
	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PasswordResetResponse> updatePasswordReset(
			@Valid @PathVariable String id,
			@RequestBody PasswordResetRequest request,
			@AuthenticationPrincipal Jwt jwt
	) {
		{
			try {

				PasswordResetResponse response = applicationService.updatePasswordReset(PasswordResetId.create(id),
						request,
						RequestContext.getUserId(jwt)
				);

				return ResponseEntity.ok(response);

			} catch (Exception ex) {
				log.error("Failed to Update passwordReset: {}", ex.getMessage(), ex);
				return ResponseEntity.internalServerError().build();
			}
		}
	}
}
