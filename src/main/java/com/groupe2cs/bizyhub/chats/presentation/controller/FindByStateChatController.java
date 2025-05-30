package com.groupe2cs.bizyhub.chats.presentation.controller;

import com.groupe2cs.bizyhub.chats.application.dto.ChatResponse;
import com.groupe2cs.bizyhub.chats.application.usecase.ChatReadApplicationService;
import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatState;
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


@PreAuthorize("@chatGate.canList(authentication)")
@RestController
@RequestMapping("/api/v1/queries/chat")
@Tag(name = "Chat Queries", description = "Endpoints for querying chats by state")
@Slf4j
public class FindByStateChatController {

	private final ChatReadApplicationService applicationService;

	public FindByStateChatController(ChatReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@GetMapping("/state")
	@Operation(
			summary = "Find chat by state",
			description = "Returns a list of chats that match the given state"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Query successful",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = ChatResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})

	public ResponseEntity<List<ChatResponse>> findByState(
			@AuthenticationPrincipal Jwt jwt,
			@Parameter(description = "Value of the state to filter by", required = true)
			@RequestParam String state
	) {
		try {

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
					.build();
			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			var future = applicationService.findByChatState(ChatState
					.create(state), metaRequest);

			return ResponseEntity.ok(future);
		} catch (Exception e) {
			log.error("Failed to find chat by state: {}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
}