package com.groupe2cs.bizyhub.tenant.presentation.controller;

import com.groupe2cs.bizyhub.tenant.application.usecase.*;
import com.groupe2cs.bizyhub.tenant.application.dto.*;
import com.groupe2cs.bizyhub.tenant.application.mapper.*;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/admin/commands/tenant")
@Tag(name = "Tenant commands", description = "Endpoints for managing tenants")
@Slf4j

public class AddTenantController {

	private final TenantCreateApplicationService applicationService;

	public AddTenantController(TenantCreateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@PostMapping
	@Operation(
			summary = "Create a new tenant",
			description = "Creates a new tenant and returns the created entity",
			requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
					description = "Tenant request payload",
					required = true,
					content = @Content(schema = @Schema(implementation = TenantRequest.class))
			)
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Successfully created",
					content = @Content(schema = @Schema(implementation = TenantResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content(schema = @Schema()))
	})
	public ResponseEntity<TenantResponse> addTenant(@Valid @RequestBody TenantRequest request,
													@AuthenticationPrincipal Jwt jwt) {
		try {

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
					.build();

			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			TenantResponse response = applicationService.createTenant(
					request,
					metaRequest
			);

			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (Exception ex) {
			//e.printStackTrace();
			log.error("Failed to create tenant: {}", ex.getMessage());
			return ResponseEntity.status(500).build();
		}
	}
}
