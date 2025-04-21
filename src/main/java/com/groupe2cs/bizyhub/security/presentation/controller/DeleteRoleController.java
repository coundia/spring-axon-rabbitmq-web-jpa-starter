package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.usecase.RoleDeleteApplicationService;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleId;
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

@PreAuthorize("@roleGate.canDelete(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/role")
@Tag(name = "Role commands", description = "Endpoints for managing roles")
@Slf4j
public class DeleteRoleController {

	private final RoleDeleteApplicationService applicationService;

	public DeleteRoleController(RoleDeleteApplicationService applicationService) {
		this.applicationService = applicationService;
	}


	@DeleteMapping("/{id}")
	@Operation(
			summary = "Delete a role",
			description = "Deletes a role based on the provided identifier"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Role deleted successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})
	public ResponseEntity<String> deleteRole(
			@Parameter(description = "ID of the role to delete", required = true)
			@PathVariable String id
	) {
		if (id == null || id.isEmpty()) {
			return ResponseEntity.badRequest().body("Invalid ID");
		}

		try {
			RoleId idVo = RoleId.create(id);
			applicationService.deleteRole(idVo);
			return ResponseEntity.ok("Role deleted successfully");
		} catch (Exception e) {
			log.error("Error deleting role with id {}: {}", id, e.getMessage());
			return ResponseEntity.internalServerError().body("Error deleting role");
		}
	}
}
