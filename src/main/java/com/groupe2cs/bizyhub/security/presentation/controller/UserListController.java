package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.UserPagedResponse;
import com.groupe2cs.bizyhub.security.application.usecase.UserReadApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("@userGate.canList(authentication)")
@RestController
@RequestMapping("/api/v1/queries/users")
@Tag(name = "User Queries", description = "Endpoints for listing paginated users")
public class UserListController {

	private final UserReadApplicationService applicationService;

	public UserListController(UserReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}


	@GetMapping
	@Operation(
			summary = "List paginated users",
			description = "Returns a paginated list of users based on page and limit parameters"
	)
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "Successfully retrieved list of users",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserPagedResponse.class))
			),
			@ApiResponse(
					responseCode = "500",
					description = "Internal server error",
					content = @Content
			)
	})
	public UserPagedResponse list(
			@Parameter(description = "Page number (zero-based index)", example = "0")
			@RequestParam(defaultValue = "0") int page,

			@Parameter(description = "Number of items per page", example = "10")
			@RequestParam(defaultValue = "10") int limit
	) {
		return applicationService.findAll(page, limit);
	}
}
