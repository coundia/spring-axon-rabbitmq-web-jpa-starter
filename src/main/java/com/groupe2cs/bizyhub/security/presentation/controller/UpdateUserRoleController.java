package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.UserRoleRequest;
import com.groupe2cs.bizyhub.security.application.dto.UserRoleResponse;
import com.groupe2cs.bizyhub.security.application.usecase.UserRoleUpdateApplicationService;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleId;
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

@PreAuthorize("@userRoleGate.canEdit(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/userRole")
@Tag(name = "UserRole commands", description = "Endpoints for managing userRoles")
@Slf4j
public class UpdateUserRoleController {

	private final UserRoleUpdateApplicationService applicationService;

	public UpdateUserRoleController(UserRoleUpdateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@Operation(summary = "Update a new userRole")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "UserRole Updated",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = UserRoleResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content)
	})
	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserRoleResponse> updateUserRole(@Valid @PathVariable String id, @RequestBody UserRoleRequest request) {
		{
			try {

				UserRoleResponse response = applicationService.updateUserRole(UserRoleId.create(id), request);

				return ResponseEntity.ok(response);

			} catch (Exception ex) {
				log.error("Failed to Update userRole: {}", ex.getMessage(), ex);
				return ResponseEntity.internalServerError().build();
			}
		}
	}
}
