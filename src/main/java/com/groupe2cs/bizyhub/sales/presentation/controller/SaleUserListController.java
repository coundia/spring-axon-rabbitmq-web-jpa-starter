package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.application.usecase.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.CompletableFuture;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;


@PreAuthorize("@saleUserGate.canList(authentication)")
@RestController
@RequestMapping("/api/v1/queries/saleUsers")
@Tag(name = "SaleUser Queries", description = "Endpoints for listing paginated saleUsers")
public class SaleUserListController {

private final SaleUserReadApplicationService applicationService;

public SaleUserListController(SaleUserReadApplicationService  applicationService) {
	this.applicationService = applicationService;
}


@GetMapping
@Operation(
summary = "List paginated saleUsers",
description = "Returns a paginated list of saleUsers based on page and limit parameters"
)
@ApiResponses(value = {
@ApiResponse(
responseCode = "200",
description = "Successfully retrieved list of saleUsers",
content = @Content(mediaType = "application/json", schema = @Schema(implementation = SaleUserPagedResponse.class))
),
@ApiResponse(
responseCode = "500",
description = "Internal server error",
content = @Content
)
})
public SaleUserPagedResponse list(
@AuthenticationPrincipal Jwt jwt,
@Parameter(description = "Page number (zero-based index)", example = "0")
@RequestParam(defaultValue = "0") int page,

@Parameter(description = "Number of items per page", example = "10")
@RequestParam(defaultValue = "10") int limit
) {

	MetaRequest metaRequest = MetaRequest.builder()
		.userId(RequestContext.getUserId(jwt))		.tenantId(RequestContext.getTenantId(jwt))
	.build();

	metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

	return applicationService.findAll(page,limit, metaRequest);
 }
}
