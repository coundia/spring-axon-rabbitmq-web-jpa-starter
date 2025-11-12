package com.groupe2cs.bizyhub.categories.presentation.controller;

import com.groupe2cs.bizyhub.categories.application.dto.CategoryPagedResponse;
import com.groupe2cs.bizyhub.categories.application.dto.CategoryResponse;
import com.groupe2cs.bizyhub.categories.application.mapper.CategoryMapper;
import com.groupe2cs.bizyhub.categories.infrastructure.entity.Category;
import com.groupe2cs.bizyhub.categories.infrastructure.repository.CategoryRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/public/queries/categories")
@Tag(name = "Category Queries", description = "Endpoints public for listing paginated categories")
public class CategoryPublicController {

	private final CurrentTenantIdentifierResolver currentTenantIdentifierResolver;
	private final CategoryRepository repository;

	@GetMapping
	@Operation(summary = "List paginated categories", description = "Returns a paginated list of categories based on page and limit parameters")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully retrieved list of categories", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoryPagedResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})
	public CategoryPagedResponse list(
			@Parameter(description = "Page number (zero-based index)", example = "0") @RequestParam(defaultValue = "0") int page,
			@Parameter(description = "Number of items per page", example = "10") @RequestParam(defaultValue = "10") int limit
	) {
		String tenantId = currentTenantIdentifierResolver.resolveCurrentTenantIdentifier();
		Page<Category> paged = repository.findPublicByTenantId(tenantId, PageRequest.of(page, limit));
		List<CategoryResponse> content = paged.getContent().stream().map(CategoryMapper::toResponse).toList();
		return CategoryPagedResponse.from(paged, content);
	}
}
