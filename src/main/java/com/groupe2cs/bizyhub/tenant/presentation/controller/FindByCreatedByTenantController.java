package com.groupe2cs.bizyhub.tenant.presentation.controller;

import com.groupe2cs.bizyhub.tenant.application.dto.TenantResponse;
import com.groupe2cs.bizyhub.tenant.application.usecase.TenantReadApplicationService;
import com.groupe2cs.bizyhub.tenant.domain.valueObject.TenantCreatedBy;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/queries/tenant")
@Tag(name = "Tenant Queries", description = "Endpoints for querying tenants by createdBy")
@Slf4j
public class FindByCreatedByTenantController {

	private final TenantReadApplicationService applicationService;

	public FindByCreatedByTenantController(TenantReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@GetMapping("/createdBy")
	@Operation(
			summary = "Find tenant by createdBy",
			description = "Returns a list of tenants that match the given createdBy"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Query successful",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = TenantResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})

	public ResponseEntity<List<TenantResponse>> findByCreatedBy(
			@Parameter(description = "Value of the createdBy to filter by", required = true)
			@RequestParam String createdBy
	) {
		try {

			var future = applicationService.findByTenantCreatedBy(TenantCreatedBy.create(createdBy));
			return ResponseEntity.ok(future);
		} catch (Exception e) {
			log.error("Failed to find tenant by createdBy: {}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
}