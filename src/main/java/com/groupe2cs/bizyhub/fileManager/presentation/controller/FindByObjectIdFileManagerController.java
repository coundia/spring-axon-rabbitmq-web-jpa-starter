package com.groupe2cs.bizyhub.fileManager.presentation.controller;

import com.groupe2cs.bizyhub.fileManager.application.dto.FileManagerResponse;
import com.groupe2cs.bizyhub.fileManager.application.usecase.FileManagerReadApplicationService;
import com.groupe2cs.bizyhub.fileManager.domain.valueObject.FileManagerObjectId;
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


@PreAuthorize("@fileManagerGate.canList(authentication)")
@RestController
@RequestMapping("/api/v1/queries/fileManager")
@Tag(name = "FileManager Queries", description = "Endpoints for querying fileManagers by objectId")
@Slf4j
public class FindByObjectIdFileManagerController {

	private final FileManagerReadApplicationService applicationService;

	public FindByObjectIdFileManagerController(FileManagerReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@GetMapping("/objectId")
	@Operation(
			summary = "Find fileManager by objectId",
			description = "Returns a list of fileManagers that match the given objectId"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Query successful",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = FileManagerResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})

	public ResponseEntity<List<FileManagerResponse>> findByObjectId(
			@AuthenticationPrincipal Jwt jwt,
			@Parameter(description = "Value of the objectId to filter by", required = true)
			@RequestParam String objectId
	) {
		try {

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
					.build();
			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			var future = applicationService.findByFileManagerObjectId(FileManagerObjectId
					.create(objectId), metaRequest);

			return ResponseEntity.ok(future);
		} catch (Exception e) {
			log.error("Failed to find fileManager by objectId: {}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
}