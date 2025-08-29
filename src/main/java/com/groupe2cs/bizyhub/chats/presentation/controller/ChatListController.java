package com.groupe2cs.bizyhub.chats.presentation.controller;

import com.groupe2cs.bizyhub.chats.application.dto.ChatPagedResponse;
import com.groupe2cs.bizyhub.chats.application.usecase.ChatReadApplicationService;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@PreAuthorize("@chatGate.canList(authentication)")
@RestController
@RequestMapping("/api/v1/queries/chats")
@Tag(name = "Chat Queries", description = "Endpoints for listing paginated chats")
public class ChatListController {

	private final ChatReadApplicationService applicationService;

	public ChatListController(ChatReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}


	@GetMapping
	@Operation(
			summary = "List paginated chats",
			description = "Returns a paginated list of chats based on page and limit parameters"
	)
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "Successfully retrieved list of chats",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = ChatPagedResponse.class))
			),
			@ApiResponse(
					responseCode = "500",
					description = "Internal server error",
					content = @Content
			)
	})
	public ChatPagedResponse list(
			@AuthenticationPrincipal Jwt jwt,
			@Parameter(description = "Page number (zero-based index)", example = "0")
			@RequestParam(defaultValue = "0") int page,

			@Parameter(description = "Number of items per page", example = "10")
			@RequestParam(defaultValue = "10") int limit
	) {

		MetaRequest metaRequest = MetaRequest.builder()
				.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
				.build();

		metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

		return applicationService.findAll(page, limit, metaRequest);
	}
}
