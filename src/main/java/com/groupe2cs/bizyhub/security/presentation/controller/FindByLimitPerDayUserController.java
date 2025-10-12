package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.application.dto.UserResponse;
import com.groupe2cs.bizyhub.security.application.usecase.UserReadApplicationService;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserLimitPerDay;
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

import java.util.List;


@PreAuthorize("@userGate.canList(authentication)")
@RestController
@RequestMapping("/api/v1/admin/queries/user")
@Tag(name = "User Queries", description = "Endpoints for querying users by limitPerDay")
@Slf4j
public class FindByLimitPerDayUserController {

	private final UserReadApplicationService applicationService;

	public FindByLimitPerDayUserController(UserReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@GetMapping("/limitPerDay")
	@Operation(
			summary = "Find user by limitPerDay",
			description = "Returns a list of users that match the given limitPerDay"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Query successful",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})

	public ResponseEntity<List<UserResponse>> findByLimitPerDay(
			@AuthenticationPrincipal Jwt jwt,
			@Parameter(description = "Value of the limitPerDay to filter by", required = true)
			@RequestParam Integer limitPerDay
	) {
		try {

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
					.build();
			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			var future = applicationService.findByUserLimitPerDay(UserLimitPerDay
					.create(limitPerDay), metaRequest);

			return ResponseEntity.ok(future);
		} catch (Exception e) {
			log.error("Failed to find user by limitPerDay: {}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
}