package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.PermissionResponse;
import com.groupe2cs.bizyhub.security.application.usecase.PermissionReadApplicationService;
import com.groupe2cs.bizyhub.security.domain.valueObject.PermissionName;
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

@PreAuthorize("@permissionGate.canRead(authentication, #id)")
@RestController
@RequestMapping("/api/v1/queries/permission")
@Tag(name = "Permission Queries", description = "Endpoints for querying permissions by name")
@Slf4j
public class FindByNamePermissionController {

	private final PermissionReadApplicationService applicationService;

	public FindByNamePermissionController(PermissionReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@GetMapping("/name")
	@Operation(
			summary = "Find permission by name",
			description = "Returns a list of permissions that match the given name"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Query successful",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = PermissionResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})

	public ResponseEntity<List<PermissionResponse>> findByName(
			@Parameter(description = "Value of the name to filter by", required = true)
			@RequestParam String name
	) {
		try {

			var future = applicationService.findByPermissionName(PermissionName.create(name));
			return ResponseEntity.ok(future);
		} catch (Exception e) {
			log.error("Failed to find permission by name: {}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
}