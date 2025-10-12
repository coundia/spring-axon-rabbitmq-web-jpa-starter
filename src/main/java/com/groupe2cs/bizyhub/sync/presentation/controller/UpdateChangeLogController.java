package com.groupe2cs.bizyhub.sync.presentation.controller;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import com.groupe2cs.bizyhub.sync.application.dto.ChangeLogRequest;
import com.groupe2cs.bizyhub.sync.application.dto.ChangeLogResponse;
import com.groupe2cs.bizyhub.sync.application.usecase.ChangeLogUpdateApplicationService;
import com.groupe2cs.bizyhub.sync.domain.valueObject.ChangeLogId;
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

@PreAuthorize("@changeLogGate.canEdit(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/changeLog")
@Tag(name = "ChangeLog commands", description = "Endpoints for managing changeLogs")
@Slf4j
public class UpdateChangeLogController {

	private final ChangeLogUpdateApplicationService applicationService;

	public UpdateChangeLogController(ChangeLogUpdateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@Operation(summary = "Update a new changeLog")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "ChangeLog Updated",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = ChangeLogResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content)
	})
	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ChangeLogResponse> updateChangeLog(
			@Valid @PathVariable String id,
			@RequestBody ChangeLogRequest request,
			@AuthenticationPrincipal Jwt jwt
	) {
		{
			try {

				MetaRequest metaRequest = MetaRequest.builder()
						.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
						.build();

				metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

				ChangeLogResponse response = applicationService.updateChangeLog(ChangeLogId.create(id),
						request,
						metaRequest
				);

				return ResponseEntity.ok(response);

			} catch (Exception ex) {
				//e.printStackTrace();
				log.error("Failed to Update changeLog: {}", ex.getMessage(), ex);
				return ResponseEntity.internalServerError().build();
			}
		}
	}
}
