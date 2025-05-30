package com.groupe2cs.bizyhub.notifications.presentation.controller;

import com.groupe2cs.bizyhub.notifications.application.dto.NotificationResponse;
import com.groupe2cs.bizyhub.notifications.application.usecase.NotificationReadApplicationService;
import com.groupe2cs.bizyhub.notifications.domain.valueObject.NotificationCreatedBy;
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


@PreAuthorize("@notificationGate.canList(authentication)")
@RestController
@RequestMapping("/api/v1/queries/notification")
@Tag(name = "Notification Queries", description = "Endpoints for querying notifications by createdBy")
@Slf4j
public class FindByCreatedByNotificationController {

	private final NotificationReadApplicationService applicationService;

	public FindByCreatedByNotificationController(NotificationReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@GetMapping("/createdBy")
	@Operation(
			summary = "Find notification by createdBy",
			description = "Returns a list of notifications that match the given createdBy"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Query successful",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = NotificationResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})

	public ResponseEntity<List<NotificationResponse>> findByCreatedBy(
			@AuthenticationPrincipal Jwt jwt,
			@Parameter(description = "Value of the createdBy to filter by", required = true)
			@RequestParam String createdBy
	) {
		try {

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
					.build();
			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			var future = applicationService.findByNotificationCreatedBy(NotificationCreatedBy
					.create(createdBy), metaRequest);

			return ResponseEntity.ok(future);
		} catch (Exception e) {
			log.error("Failed to find notification by createdBy: {}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
}