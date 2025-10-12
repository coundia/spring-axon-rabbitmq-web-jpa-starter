package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.usecase.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import lombok.AllArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

@PreAuthorize("@roleGate.canEdit(authentication, #id)")
@RestController
@RequestMapping("/api/v1/admin/commands/role")
@Tag(name = "Role commands", description = "Endpoints for managing roles")
@Slf4j
public class UpdateRoleController {

	private final RoleUpdateApplicationService applicationService;

	public UpdateRoleController(RoleUpdateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@Operation(summary = "Update a new role")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Role Updated",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = RoleResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content)
	})
	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RoleResponse> updateRole(
			@Valid @PathVariable String id,
			@RequestBody RoleRequest request,
			@AuthenticationPrincipal Jwt jwt
	) {
		{
			try {

				MetaRequest metaRequest = MetaRequest.builder()
						.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
						.build();

				metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

				RoleResponse response = applicationService.updateRole(RoleId.create(id),
						request,
						metaRequest
				);

				return ResponseEntity.ok(response);

			} catch (Exception ex) {
				//e.printStackTrace();
				log.error("Failed to Update role: {}", ex.getMessage(), ex);
				return ResponseEntity.internalServerError().build();
			}
		}
	}
}
