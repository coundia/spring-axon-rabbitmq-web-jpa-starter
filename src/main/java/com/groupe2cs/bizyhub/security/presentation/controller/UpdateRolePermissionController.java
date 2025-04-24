package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.RolePermissionRequest;
import com.groupe2cs.bizyhub.security.application.dto.RolePermissionResponse;
import com.groupe2cs.bizyhub.security.application.usecase.RolePermissionUpdateApplicationService;
import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionId;
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

@PreAuthorize("@rolePermissionGate.canEdit(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/rolePermission")
@Tag(name = "RolePermission commands", description = "Endpoints for managing rolePermissions")
@Slf4j
public class UpdateRolePermissionController {

	private final RolePermissionUpdateApplicationService applicationService;

	public UpdateRolePermissionController(RolePermissionUpdateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@Operation(summary = "Update a new rolePermission")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "RolePermission Updated",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = RolePermissionResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content)
	})
	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RolePermissionResponse> updateRolePermission(
			@Valid @PathVariable String id,
			@RequestBody RolePermissionRequest request,
			@AuthenticationPrincipal Jwt jwt
	) {
		{
			try {

				RolePermissionResponse response = applicationService.updateRolePermission(RolePermissionId.create(id),
						request,
						RequestContext.getUserId(jwt)
				);

				return ResponseEntity.ok(response);

			} catch (Exception ex) {
				log.error("Failed to Update rolePermission: {}", ex.getMessage(), ex);
				return ResponseEntity.internalServerError().build();
			}
		}
	}
}
