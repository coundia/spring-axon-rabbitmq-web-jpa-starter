package com.groupe2cs.bizyhub.products.presentation.controller;

import com.groupe2cs.bizyhub.products.domain.valueObject.ProductId;
import com.groupe2cs.bizyhub.products.application.usecase.ProductUpdateApplicationService;
import com.groupe2cs.bizyhub.products.application.dto.ProductRequest;
import com.groupe2cs.bizyhub.products.application.dto.ProductResponse;
import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("@productGate.canEdit(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/product")
@Tag(name = "Product commands", description = "Endpoints for managing products")
@Slf4j
public class UpdateProductController {

	private final ProductUpdateApplicationService applicationService;

	public UpdateProductController(ProductUpdateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@Operation(summary = "Update a product")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Product updated successfully",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = ProductResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content)
	})
	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateProduct(
			@Valid @PathVariable String id,
			@RequestBody ProductRequest request,
			@AuthenticationPrincipal Jwt jwt
	) {
		try {
			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt))
					.tenantId(RequestContext.getTenantId(jwt))
					.build();
			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			ProductResponse response = applicationService.updateProduct(
					ProductId.create(id),
					request,
					metaRequest
			);

			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			log.error("Failed to update product with id {}: {}", id, ex.getMessage(), ex);
			return ResponseEntity.internalServerError().body(
					ApiResponseDto.builder()
							.code(0)
							.message(ex.getMessage())
							.build()
			);
		}
	}
}
