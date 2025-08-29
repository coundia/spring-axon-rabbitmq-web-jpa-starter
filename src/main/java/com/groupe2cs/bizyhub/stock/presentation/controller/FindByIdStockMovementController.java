package com.groupe2cs.bizyhub.stock.presentation.controller;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import com.groupe2cs.bizyhub.stock.application.dto.StockMovementResponse;
import com.groupe2cs.bizyhub.stock.application.usecase.StockMovementReadApplicationService;
import com.groupe2cs.bizyhub.stock.domain.valueObject.StockMovementId;
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


@PreAuthorize("@stockMovementGate.canRead(authentication, #id)")
@RestController
@RequestMapping("/api/v1/queries/stockMovement")
@Tag(name = "StockMovement Queries", description = "Endpoints for querying stockMovements by id")
@Slf4j
public class FindByIdStockMovementController {

	private final StockMovementReadApplicationService applicationService;

	public FindByIdStockMovementController(StockMovementReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@GetMapping("/id")
	@Operation(
			summary = "Find stockMovement by id",
			description = "Returns a single stockMovements that match the given id"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Query successful",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = StockMovementResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})

	public ResponseEntity<StockMovementResponse> findById(
			@AuthenticationPrincipal Jwt jwt,
			@Parameter(description = "Value of the id to filter by", required = true)
			@RequestParam String id
	) {
		try {

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
					.build();
			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			var future = applicationService.findByStockMovementId(StockMovementId
					.create(id), metaRequest);

			return ResponseEntity.ok(future);
		} catch (Exception e) {
			log.error("Failed to find stockMovement by id: {}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
}