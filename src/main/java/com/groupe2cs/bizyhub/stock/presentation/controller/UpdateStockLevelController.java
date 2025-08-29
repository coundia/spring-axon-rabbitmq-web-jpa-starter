package com.groupe2cs.bizyhub.stock.presentation.controller;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import com.groupe2cs.bizyhub.stock.application.dto.StockLevelRequest;
import com.groupe2cs.bizyhub.stock.application.dto.StockLevelResponse;
import com.groupe2cs.bizyhub.stock.application.usecase.StockLevelUpdateApplicationService;
import com.groupe2cs.bizyhub.stock.domain.valueObject.StockLevelId;
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

@PreAuthorize("@stockLevelGate.canEdit(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/stockLevel")
@Tag(name = "StockLevel commands", description = "Endpoints for managing stockLevels")
@Slf4j
public class UpdateStockLevelController {

	private final StockLevelUpdateApplicationService applicationService;

	public UpdateStockLevelController(StockLevelUpdateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@Operation(summary = "Update a new stockLevel")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "StockLevel Updated",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = StockLevelResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content)
	})
	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockLevelResponse> updateStockLevel(
			@Valid @PathVariable String id,
			@RequestBody StockLevelRequest request,
			@AuthenticationPrincipal Jwt jwt
	) {
		{
			try {

				MetaRequest metaRequest = MetaRequest.builder()
						.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
						.build();

				metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

				StockLevelResponse response = applicationService.updateStockLevel(StockLevelId.create(id),
						request,
						metaRequest
				);

				return ResponseEntity.ok(response);

			} catch (Exception ex) {
				//e.printStackTrace();
				log.error("Failed to Update stockLevel: {}", ex.getMessage(), ex);
				return ResponseEntity.internalServerError().build();
			}
		}
	}
}
