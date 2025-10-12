package com.groupe2cs.bizyhub.stock.presentation.controller;

import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import com.groupe2cs.bizyhub.stock.application.usecase.StockMovementDeleteApplicationService;
import com.groupe2cs.bizyhub.stock.domain.valueObject.StockMovementId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@PreAuthorize("@stockMovementGate.canDelete(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/stockMovement")
@Tag(name = "StockMovement commands", description = "Endpoints for managing stockMovements")
@Slf4j
public class DeleteStockMovementController {

	private final StockMovementDeleteApplicationService applicationService;

	public DeleteStockMovementController(StockMovementDeleteApplicationService applicationService) {
		this.applicationService = applicationService;
	}


	@DeleteMapping("/{id}")
	@Operation(
			summary = "Delete a stockMovement",
			description = "Deletes a stockMovement based on the provided identifier"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "StockMovement deleted successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	}
	)
	public ResponseEntity<ApiResponseDto> deleteStockMovement(
			@Parameter(description = "ID of the stockMovement to delete", required = true)
			@PathVariable String id,
			@AuthenticationPrincipal Jwt jwt
	) {
		if (id == null || id.isEmpty()) {

			return ResponseEntity.badRequest().body(
					ApiResponseDto.builder()
							.code(0)
							.message("Invalid ID supplied")
							.build()
			);
		}

		try {
			StockMovementId idVo = StockMovementId.create(id);

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
					.build();

			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			applicationService.deleteStockMovement(idVo, metaRequest);

			return ResponseEntity.ok(
					ApiResponseDto.builder()
							.code(1)
							.message("stockMovement with id " + id + " deleted successfully")
							.build()
			);
		} catch (Exception e) {
			log.error("Error deleting stockMovement with id {}: {}", id, e.getMessage());
			return ResponseEntity.internalServerError().body(
					ApiResponseDto.builder()
							.code(0)
							.message(e.getMessage())
							.build()
			);
		}
	}
}
