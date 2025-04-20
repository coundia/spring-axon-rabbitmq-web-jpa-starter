package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.application.usecase.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf;
import static org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf;

@RestController
@RequestMapping("/api/v1/queries/role")
@Tag(name = "Role Queries", description = "Endpoints for querying roles by name")
@Slf4j
public class FindByNameRoleController {

private final RoleReadApplicationService applicationService;

public FindByNameRoleController(RoleReadApplicationService  applicationService) {
	this.applicationService = applicationService;
}

@GetMapping("/by-name")
@Operation(
summary = "Find role by name",
description = "Returns a list of roles that match the given name"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Query successful",
content = @Content(mediaType = "application/json", schema = @Schema(implementation = RoleResponse.class))),
@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})

public ResponseEntity<List<RoleResponse>> findByName(
	@Parameter(description = "Value of the name to filter by", required = true)
	@RequestParam String name
	) {
	try {

	var future = applicationService.findByRoleName(RoleName.create(name));
	return ResponseEntity.ok(future);
	} catch (Exception e) {
	log.error("Failed to find role by name: {}", e.getMessage(), e);
	return ResponseEntity.internalServerError().build();
	}
	}
}