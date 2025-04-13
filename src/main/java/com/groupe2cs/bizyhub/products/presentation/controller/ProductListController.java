package com.groupe2cs.bizyhub.products.presentation.controller;

import com.groupe2cs.bizyhub.products.application.dto.*;
import com.groupe2cs.bizyhub.products.application.usecase.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/queries/list-product")
@Tag(name = "Product Queries", description = "Endpoints for listing paginated products")
public class ProductListController {

private final ProductReadApplicationService applicationService;

public ProductListController(ProductReadApplicationService  applicationService) {
	this.applicationService = applicationService;
}


@GetMapping
@Operation(
summary = "List paginated products",
description = "Returns a paginated list of products based on page and limit parameters"
)
@ApiResponses(value = {
@ApiResponse(
responseCode = "200",
description = "Successfully retrieved list of products",
content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductPagedResponse.class))
),
@ApiResponse(
responseCode = "500",
description = "Internal server error",
content = @Content
)
})
public ProductPagedResponse list(
@Parameter(description = "Page number (zero-based index)", example = "0")
@RequestParam(defaultValue = "0") int page,

@Parameter(description = "Number of items per page", example = "10")
@RequestParam(defaultValue = "10") int limit
) {
	return applicationService.findAll(page,limit);
 }
}
