package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.RolePermissionResponse;
import com.groupe2cs.bizyhub.security.application.usecase.RolePermissionReadApplicationService;
import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionRole;
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


@PreAuthorize("@rolePermissionGate.canList(authentication)")
@RestController
@RequestMapping("/api/v1/admin/queries/rolePermission")
@Tag(name = "RolePermission Queries", description = "Endpoints for querying rolePermissions by role")
@Slf4j
public class FindByRoleRolePermissionController {

	private final RolePermissionReadApplicationService applicationService;

	public FindByRoleRolePermissionController(RolePermissionReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@GetMapping("/role")
	@Operation(
			summary = "Find rolePermission by role",
			description = "Returns a list of rolePermissions that match the given role"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Query successful",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = RolePermissionResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})

	public ResponseEntity<List<RolePermissionResponse>> findByRole(
			@AuthenticationPrincipal Jwt jwt,
			@Parameter(description = "Value of the role to filter by", required = true)
			@RequestParam String role
	) {
		try {

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
					.build();
			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			var future = applicationService.findByRolePermissionRole(RolePermissionRole
					.create(role), metaRequest);

			return ResponseEntity.ok(future);
		} catch (Exception e) {
			log.error("Failed to find rolePermission by role: {}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
}