package com.groupe2cs.bizyhub.sync.presentation.controller;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import com.groupe2cs.bizyhub.sync.application.dto.ChangeLogRequest;
import com.groupe2cs.bizyhub.sync.application.dto.ChangeLogResponse;
import com.groupe2cs.bizyhub.sync.application.usecase.ChangeLogCreateApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("@changeLogGate.canCreate(authentication)")

@RestController
@RequestMapping("/api/v1/commands/changeLog")
@Tag(name = "ChangeLog commands", description = "Endpoints for managing changeLogs")
@Slf4j

public class AddChangeLogController {

	private final ChangeLogCreateApplicationService applicationService;

	public AddChangeLogController(ChangeLogCreateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@PostMapping
	@Operation(
			summary = "Create a new changeLog",
			description = "Creates a new changeLog and returns the created entity",
			requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
					description = "ChangeLog request payload",
					required = true,
					content = @Content(schema = @Schema(implementation = ChangeLogRequest.class))
			)
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Successfully created",
					content = @Content(schema = @Schema(implementation = ChangeLogResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content(schema = @Schema()))
	})
	public ResponseEntity<ChangeLogResponse> addChangeLog(@Valid @RequestBody ChangeLogRequest request,
														  @AuthenticationPrincipal Jwt jwt) {
		try {

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
					.build();

			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			ChangeLogResponse response = applicationService.createChangeLog(
					request,
					metaRequest
			);

			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (Exception ex) {
			//e.printStackTrace();
			log.error("Failed to create changeLog: {}", ex.getMessage());
			return ResponseEntity.status(500).build();
		}
	}
}
