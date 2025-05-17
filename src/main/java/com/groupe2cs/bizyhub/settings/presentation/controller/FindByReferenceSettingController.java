package com.groupe2cs.bizyhub.settings.presentation.controller;

import com.groupe2cs.bizyhub.settings.application.dto.SettingResponse;
import com.groupe2cs.bizyhub.settings.application.usecase.SettingReadApplicationService;
import com.groupe2cs.bizyhub.settings.domain.valueObject.SettingReference;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@PreAuthorize("@settingGate.canList(authentication)")
@RestController
@RequestMapping("/api/v1/queries/setting")
@Tag(name = "Setting Queries", description = "Endpoints for querying settings by reference")
@Slf4j
public class FindByReferenceSettingController {

	private final SettingReadApplicationService applicationService;

	public FindByReferenceSettingController(SettingReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@GetMapping("/reference")
	@Operation(
			summary = "Find setting by reference",
			description = "Returns a list of settings that match the given reference"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Query successful",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = SettingResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})

	public ResponseEntity<List<SettingResponse>> findByReference(
			@AuthenticationPrincipal Jwt jwt,
			@Parameter(description = "Value of the reference to filter by", required = true)
			@RequestParam String reference
	) {
		try {

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
					.build();
			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			var future = applicationService.findBySettingReference(SettingReference
					.create(reference), metaRequest);

			return ResponseEntity.ok(future);
		} catch (Exception e) {
			log.error("Failed to find setting by reference: {}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
}