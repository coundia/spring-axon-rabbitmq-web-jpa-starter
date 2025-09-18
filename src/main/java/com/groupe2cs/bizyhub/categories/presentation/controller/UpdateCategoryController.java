package com.groupe2cs.bizyhub.categories.presentation.controller;

import com.groupe2cs.bizyhub.categories.domain.valueObject.CategoryId;
import com.groupe2cs.bizyhub.categories.application.usecase.CategoryUpdateApplicationService;
import com.groupe2cs.bizyhub.categories.application.dto.CategoryRequest;
import com.groupe2cs.bizyhub.categories.application.dto.CategoryResponse;
import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("@categoryGate.canEdit(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/category")
@Tag(name = "Category commands", description = "Endpoints for managing categories")
@Slf4j
public class UpdateCategoryController {

	private final CategoryUpdateApplicationService applicationService;

	public UpdateCategoryController(CategoryUpdateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@Operation(summary = "Update a category")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Category updated",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = CategoryResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})
	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateCategory(
			@Valid @PathVariable String id,
			@RequestBody CategoryRequest request,
			@AuthenticationPrincipal Jwt jwt
	) {
		try {
			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt))
					.tenantId(RequestContext.getTenantId(jwt))
					.build();
			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			CategoryResponse response = applicationService.updateCategory(
					CategoryId.create(id),
					request,
					metaRequest
			);

			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			log.error("Failed to update category with id {}: {}", id, ex.getMessage(), ex);
			return ResponseEntity.internalServerError().body(
					ApiResponseDto.builder()
							.code(0)
							.message("Erreur lors de la mise à jour de la catégorie : " + ex.getMessage())
							.build()
			);
		}
	}
}
