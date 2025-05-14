package com.groupe2cs.bizyhub.categories.presentation.controller;

import com.groupe2cs.bizyhub.categories.application.dto.CategoryResponse;
import com.groupe2cs.bizyhub.categories.application.usecase.CategoryReadApplicationService;
import com.groupe2cs.bizyhub.categories.domain.valueObject.CategoryId;
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


@PreAuthorize("@categoryGate.canRead(authentication, #id)")
@RestController
@RequestMapping("/api/v1/queries/category")
@Tag(name = "Category Queries", description = "Endpoints for querying categorys by id")
@Slf4j
public class FindByIdCategoryController {

	private final CategoryReadApplicationService applicationService;

	public FindByIdCategoryController(CategoryReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@GetMapping("/id")
	@Operation(
			summary = "Find category by id",
			description = "Returns a single categorys that match the given id"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Query successful",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})

	public ResponseEntity<CategoryResponse> findById(
			@AuthenticationPrincipal Jwt jwt,
			@Parameter(description = "Value of the id to filter by", required = true)
			@RequestParam String id
	) {
		try {

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
					.build();
			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			var future = applicationService.findByCategoryId(CategoryId
					.create(id), metaRequest);

			return ResponseEntity.ok(future);
		} catch (Exception e) {
			log.error("Failed to find category by id: {}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
}