package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.RoleResponse;
import com.groupe2cs.bizyhub.security.application.usecase.RoleReadApplicationService;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleId;
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

@PreAuthorize("@roleGate.canRead(authentication, #id)")
@RestController
@RequestMapping("/api/v1/queries/role")
@Tag(name = "Role Queries", description = "Endpoints for querying roles by id")
@Slf4j
public class FindByIdRoleController {

	private final RoleReadApplicationService applicationService;

	public FindByIdRoleController(RoleReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@GetMapping("/id")
	@Operation(
			summary = "Find role by id",
			description = "Returns a single roles that match the given id"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Query successful",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = RoleResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})

	public ResponseEntity<RoleResponse> findById(
			@Parameter(description = "Value of the id to filter by", required = true)
			@RequestParam String id
	) {
		try {

			var future = applicationService.findByRoleId(RoleId.create(id));
			return ResponseEntity.ok(future);
		} catch (Exception e) {
			log.error("Failed to find role by id: {}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
}