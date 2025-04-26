package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.usecase.UserDeleteApplicationService;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserId;
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

@PreAuthorize("@userGate.canDelete(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/user")
@Tag(name = "User commands", description = "Endpoints for managing users")
@Slf4j
public class DeleteUserController {

	private final UserDeleteApplicationService applicationService;

	public DeleteUserController(UserDeleteApplicationService applicationService) {
		this.applicationService = applicationService;
	}


	@DeleteMapping("/{id}")
	@Operation(
			summary = "Delete a user",
			description = "Deletes a user based on the provided identifier"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "User deleted successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})
	public ResponseEntity<String> deleteUser(
			@Parameter(description = "ID of the user to delete", required = true)
			@PathVariable String id
	) {
		if (id == null || id.isEmpty()) {
			return ResponseEntity.badRequest().body("Invalid ID");
		}

		try {
			UserId idVo = UserId.create(id);
			applicationService.deleteUser(idVo);
			return ResponseEntity.ok("User deleted successfully");
		} catch (Exception e) {
			log.error("Error deleting user with id {}: {}", id, e.getMessage());
			return ResponseEntity.internalServerError().body("Error deleting user");
		}
	}
}
