package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.PermissionRequest;
import com.groupe2cs.bizyhub.security.application.dto.PermissionResponse;
import com.groupe2cs.bizyhub.security.application.usecase.PermissionUpdateApplicationService;
import com.groupe2cs.bizyhub.security.domain.valueObject.PermissionId;
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

@PreAuthorize("@permissionGate.canEdit(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/permission")
@Tag(name = "Permission commands", description = "Endpoints for managing permissions")
@Slf4j
public class UpdatePermissionController {

	private final PermissionUpdateApplicationService applicationService;

	public UpdatePermissionController(PermissionUpdateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@Operation(summary = "Update a new permission")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Permission Updated",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = PermissionResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content)
	})
	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PermissionResponse> updatePermission(
			@Valid @PathVariable String id,
			@RequestBody PermissionRequest request,
			@AuthenticationPrincipal Jwt jwt
	) {
		{
			try {

				PermissionResponse response = applicationService.updatePermission(PermissionId.create(id),
						request,
						RequestContext.getUserId(jwt)
				);

				return ResponseEntity.ok(response);

			} catch (Exception ex) {
				log.error("Failed to Update permission: {}", ex.getMessage(), ex);
				return ResponseEntity.internalServerError().build();
			}
		}
	}
}
