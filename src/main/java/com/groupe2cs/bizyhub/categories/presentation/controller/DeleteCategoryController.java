package com.groupe2cs.bizyhub.categories.presentation.controller;

	import com.groupe2cs.bizyhub.categories.application.mapper.*;
	import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
	import com.groupe2cs.bizyhub.categories.domain.exception.*;
	import com.groupe2cs.bizyhub.categories.application.dto.*;
	import com.groupe2cs.bizyhub.categories.application.usecase.*;
	import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
	import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;

import com.groupe2cs.bizyhub.categories.application.command.DeleteCategoryCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;


@PreAuthorize("@categoryGate.canDelete(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/category")
@Tag(name = "Category commands", description = "Endpoints for managing categorys")
@Slf4j
public class DeleteCategoryController {

private final CategoryDeleteApplicationService applicationService;

public DeleteCategoryController(CategoryDeleteApplicationService applicationService) {
    this.applicationService = applicationService;
}


@DeleteMapping("/{id}")
@Operation(
summary = "Delete a category",
description = "Deletes a category based on the provided identifier"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Category deleted successfully"),
@ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})
public ResponseEntity<String> deleteCategory(
	@Parameter(description = "ID of the category to delete", required = true)
	@PathVariable String id,
	@AuthenticationPrincipal Jwt jwt
	) {
	if (id == null || id.isEmpty()) {
	return ResponseEntity.badRequest().body("Invalid ID");
	}

	try {
	CategoryId idVo = CategoryId.create(id);

	MetaRequest metaRequest = MetaRequest.builder()
	.userId(RequestContext.getUserId(jwt))		.tenantId(RequestContext.getTenantId(jwt))
	.build();

	applicationService.deleteCategory(idVo, metaRequest);

	return ResponseEntity.ok("Category deleted successfully");
	} catch (Exception e) {
	log.error("Error deleting category with id {}: {}", id, e.getMessage());
	return ResponseEntity.internalServerError().body("Error deleting category");
	}
	}
	}
