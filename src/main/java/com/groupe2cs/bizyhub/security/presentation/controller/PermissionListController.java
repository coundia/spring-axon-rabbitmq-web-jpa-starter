package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.application.usecase.*;

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
@RequestMapping("/api/v1/queries/list-permission")
@Tag(name = "Permission Queries", description = "Endpoints for listing paginated permissions")
public class PermissionListController {

private final PermissionReadApplicationService applicationService;

public PermissionListController(PermissionReadApplicationService  applicationService) {
	this.applicationService = applicationService;
}


@GetMapping
@Operation(
summary = "List paginated permissions",
description = "Returns a paginated list of permissions based on page and limit parameters"
)
@ApiResponses(value = {
@ApiResponse(
responseCode = "200",
description = "Successfully retrieved list of permissions",
content = @Content(mediaType = "application/json", schema = @Schema(implementation = PermissionPagedResponse.class))
),
@ApiResponse(
responseCode = "500",
description = "Internal server error",
content = @Content
)
})
public PermissionPagedResponse list(
@Parameter(description = "Page number (zero-based index)", example = "0")
@RequestParam(defaultValue = "0") int page,

@Parameter(description = "Number of items per page", example = "10")
@RequestParam(defaultValue = "10") int limit
) {
	return applicationService.findAll(page,limit);
 }
}
