package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.usecase.UserRoleDeleteApplicationService;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleId;
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

@PreAuthorize("@userRoleGate.canDelete(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/userRole")
@Tag(name = "UserRole commands", description = "Endpoints for managing userRoles")
@Slf4j
public class DeleteUserRoleController {

	private final UserRoleDeleteApplicationService applicationService;

	public DeleteUserRoleController(UserRoleDeleteApplicationService applicationService) {
		this.applicationService = applicationService;
	}


	@DeleteMapping("/{id}")
	@Operation(
			summary = "Delete a userRole",
			description = "Deletes a userRole based on the provided identifier"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "UserRole deleted successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})
	public ResponseEntity<String> deleteUserRole(
			@Parameter(description = "ID of the userRole to delete", required = true)
			@PathVariable String id
	) {
		if (id == null || id.isEmpty()) {
			return ResponseEntity.badRequest().body("Invalid ID");
		}

		try {
			UserRoleId idVo = UserRoleId.create(id);
			applicationService.deleteUserRole(idVo);
			return ResponseEntity.ok("UserRole deleted successfully");
		} catch (Exception e) {
			log.error("Error deleting userRole with id {}: {}", id, e.getMessage());
			return ResponseEntity.internalServerError().body("Error deleting userRole");
		}
	}
}
