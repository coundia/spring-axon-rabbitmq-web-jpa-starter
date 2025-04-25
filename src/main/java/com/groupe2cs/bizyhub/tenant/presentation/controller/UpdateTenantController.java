package com.groupe2cs.bizyhub.tenant.presentation.controller;

import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
import com.groupe2cs.bizyhub.tenant.application.usecase.*;
import com.groupe2cs.bizyhub.tenant.application.dto.*;
import com.groupe2cs.bizyhub.tenant.application.mapper.*;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import lombok.AllArgsConstructor;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/commands/tenant")
@Tag(name = "Tenant commands", description = "Endpoints for managing tenants")
@Slf4j
public class UpdateTenantController {

private final TenantUpdateApplicationService applicationService;

public UpdateTenantController(TenantUpdateApplicationService  applicationService) {
this.applicationService = applicationService;
}

@Operation(summary = "Update a new tenant")
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Tenant Updated",
content = @Content(mediaType = "application/json",
schema = @Schema(implementation = TenantResponse.class))),
@ApiResponse(responseCode = "500", description = "Internal server error",
content = @Content)
})
@PutMapping(value="{id}",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<TenantResponse> updateTenant(
	@Valid @PathVariable String id,
	@RequestBody TenantRequest request,
	@AuthenticationPrincipal Jwt jwt
	) { {
	try {

	TenantResponse response = applicationService.updateTenant(TenantId.create(id),
	request,
	RequestContext.getUserId(jwt) 
	);

	return ResponseEntity.ok(response);

	} catch (Exception ex) {
	//e.printStackTrace();
	log.error("Failed to Update tenant: {}", ex.getMessage(), ex);
	return ResponseEntity.internalServerError().build();
	}
	}
}
}
