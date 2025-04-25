package com.groupe2cs.bizyhub.security.presentation.controller;

	import com.groupe2cs.bizyhub.security.application.mapper.*;
	import com.groupe2cs.bizyhub.security.domain.valueObject.*;
	import com.groupe2cs.bizyhub.security.domain.exception.*;
	import com.groupe2cs.bizyhub.security.application.dto.*;
	import com.groupe2cs.bizyhub.security.application.usecase.*;
	import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;

import com.groupe2cs.bizyhub.security.application.command.DeletePasswordResetCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

@PreAuthorize("@passwordResetGate.canDelete(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/passwordReset")
@Tag(name = "PasswordReset commands", description = "Endpoints for managing passwordResets")
@Slf4j
public class DeletePasswordResetController {

private final PasswordResetDeleteApplicationService applicationService;

public DeletePasswordResetController(PasswordResetDeleteApplicationService applicationService) {
    this.applicationService = applicationService;
}


@DeleteMapping("/{id}")
@Operation(
summary = "Delete a passwordReset",
description = "Deletes a passwordReset based on the provided identifier"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "PasswordReset deleted successfully"),
@ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})
public ResponseEntity<String> deletePasswordReset(
	@Parameter(description = "ID of the passwordReset to delete", required = true)
	@PathVariable String id
	) {
	if (id == null || id.isEmpty()) {
	return ResponseEntity.badRequest().body("Invalid ID");
	}

	try {
	PasswordResetId idVo = PasswordResetId.create(id);
	applicationService.deletePasswordReset(idVo);
	return ResponseEntity.ok("PasswordReset deleted successfully");
	} catch (Exception e) {
	log.error("Error deleting passwordReset with id {}: {}", id, e.getMessage());
	return ResponseEntity.internalServerError().body("Error deleting passwordReset");
	}
	}
	}
