package com.groupe2cs.bizyhub.tenant.presentation.controller;

import com.groupe2cs.bizyhub.tenant.application.usecase.TenantDeleteApplicationService;
import com.groupe2cs.bizyhub.tenant.domain.valueObject.TenantId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/commands/tenant")
@Tag(name = "Tenant commands", description = "Endpoints for managing tenants")
@Slf4j
public class DeleteTenantController {

	private final TenantDeleteApplicationService applicationService;

	public DeleteTenantController(TenantDeleteApplicationService applicationService) {
		this.applicationService = applicationService;
	}


	@DeleteMapping("/{id}")
	@Operation(
			summary = "Delete a tenant",
			description = "Deletes a tenant based on the provided identifier"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Tenant deleted successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})
	public ResponseEntity<String> deleteTenant(
			@Parameter(description = "ID of the tenant to delete", required = true)
			@PathVariable String id
	) {
		if (id == null || id.isEmpty()) {
			return ResponseEntity.badRequest().body("Invalid ID");
		}

		try {
			TenantId idVo = TenantId.create(id);
			applicationService.deleteTenant(idVo);
			return ResponseEntity.ok("Tenant deleted successfully");
		} catch (Exception e) {
			log.error("Error deleting tenant with id {}: {}", id, e.getMessage());
			return ResponseEntity.internalServerError().body("Error deleting tenant");
		}
	}
}
