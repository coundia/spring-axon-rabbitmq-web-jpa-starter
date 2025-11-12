package com.groupe2cs.bizyhub.companies.presentation.controller;

import com.groupe2cs.bizyhub.companies.application.dto.CompanyRequest;
import com.groupe2cs.bizyhub.companies.application.dto.CompanyResponse;
import com.groupe2cs.bizyhub.companies.application.usecase.CompanyUpdateApplicationService;
import com.groupe2cs.bizyhub.companies.domain.valueObject.CompanyId;
import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("@companyGate.canEdit(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/company")
@Tag(name = "Company commands", description = "Endpoints for managing companies")
@Slf4j
public class UpdateCompanyController {

	private final CompanyUpdateApplicationService applicationService;

	public UpdateCompanyController(CompanyUpdateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@Operation(summary = "Update a company")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Company updated",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = CompanyResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})
	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateCompany(
			@Valid @PathVariable String id,
			@RequestBody CompanyRequest request,
			@AuthenticationPrincipal Jwt jwt
	) {
		try {
			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt))
					.tenantId(RequestContext.getTenantId(jwt))
					.build();
			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			CompanyResponse response = applicationService.updateCompany(
					CompanyId.create(id),
					request,
					metaRequest
			);

			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			log.error("Failed to update company with id {}: {}", id, ex.getMessage(), ex);
			return ResponseEntity.internalServerError().body(
					ApiResponseDto.builder()
							.code(0)
							.message(ex.getMessage())
							.build()
			);
		}
	}
}
