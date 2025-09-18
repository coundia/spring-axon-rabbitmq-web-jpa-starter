package com.groupe2cs.bizyhub.categories.presentation.controller;

import com.groupe2cs.bizyhub.categories.application.usecase.*;
import com.groupe2cs.bizyhub.categories.application.dto.*;
import com.groupe2cs.bizyhub.categories.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

@PreAuthorize("@categoryGate.canCreate(authentication)")

@RestController
@RequestMapping("/api/v1/commands/category")
@Tag(name = "Category commands", description = "Endpoints for managing categorys")
@Slf4j

public class AddCategoryController {

private final CategoryCreateApplicationService applicationService;

public AddCategoryController(CategoryCreateApplicationService applicationService) {
	this.applicationService = applicationService;
}

@PostMapping
@Operation(
summary = "Create a new category",
description = "Creates a new category and returns the created entity",
requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
description = "Category request payload",
required = true,
content = @Content(schema = @Schema(implementation = CategoryRequest.class))
)
)
@ApiResponses(value = {
@ApiResponse(responseCode = "201", description = "Successfully created",
content = @Content(schema = @Schema(implementation = CategoryResponse.class))),
@ApiResponse(responseCode = "500", description = "Internal server error",
content = @Content(schema = @Schema()))
})
public ResponseEntity<?> addCategory(@Valid @RequestBody CategoryRequest request,
	@AuthenticationPrincipal Jwt jwt) {
	try {

	MetaRequest metaRequest = MetaRequest.builder()
		.userId(RequestContext.getUserId(jwt))		.tenantId(RequestContext.getTenantId(jwt))
		.build();

		metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

	CategoryResponse response =  applicationService.createCategory(
			request,
			metaRequest
	);

	return ResponseEntity.status(HttpStatus.CREATED).body(response);
	} catch (Exception ex) {
	//e.printStackTrace();
	log.error("Failed to create category: {}", ex.getMessage());
		return ResponseEntity.internalServerError().body(
				ApiResponseDto.builder()
						.code(0)
						.message(ex.getMessage())
						.build()
		);
	}
}
}
