package com.groupe2cs.bizyhub.tenant.presentation.controller;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import com.groupe2cs.bizyhub.tenant.application.dto.TenantResponse;
import com.groupe2cs.bizyhub.tenant.application.usecase.TenantReadApplicationService;
import com.groupe2cs.bizyhub.tenant.domain.valueObject.TenantTenant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/queries/tenant")
@Tag(name = "Tenant Queries", description = "Endpoints for querying tenants by tenant")
@Slf4j
public class FindByTenantTenantController {

	private final TenantReadApplicationService applicationService;

	public FindByTenantTenantController(TenantReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@GetMapping("/tenant")
	@Operation(
			summary = "Find tenant by tenant",
			description = "Returns a list of tenants that match the given tenant"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Query successful",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = TenantResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})

	public ResponseEntity<List<TenantResponse>> findByTenant(
			@AuthenticationPrincipal Jwt jwt,
			@Parameter(description = "Value of the tenant to filter by", required = true)
			@RequestParam String tenant
	) {
		try {

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt))
					.build();

			var future = applicationService.findByTenantTenant(TenantTenant
					.create(tenant), metaRequest);

			return ResponseEntity.ok(future);
		} catch (Exception e) {
			log.error("Failed to find tenant by tenant: {}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
}