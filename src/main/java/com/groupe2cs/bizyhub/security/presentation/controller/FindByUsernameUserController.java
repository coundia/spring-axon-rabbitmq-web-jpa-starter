package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.application.usecase.*;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;

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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

@PreAuthorize("@userGate.canRead(authentication, #id)")
@RestController
@RequestMapping("/api/v1/queries/user")
@Tag(name = "User Queries", description = "Endpoints for querying users by username")
@Slf4j
public class FindByUsernameUserController {

private final UserReadApplicationService applicationService;

public FindByUsernameUserController(UserReadApplicationService  applicationService) {
	this.applicationService = applicationService;
}

@GetMapping("/username")
@Operation(
summary = "Find user by username",
description = "Returns a list of users that match the given username"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Query successful",
content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class))),
@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})

public ResponseEntity<List<UserResponse>> findByUsername(
	@Parameter(description = "Value of the username to filter by", required = true)
	@RequestParam String username
	) {
	try {

	var future = applicationService.findByUserUsername(UserUsername.create(username));
	return ResponseEntity.ok(future);
	} catch (Exception e) {
	log.error("Failed to find user by username: {}", e.getMessage(), e);
	return ResponseEntity.internalServerError().build();
	}
	}
}