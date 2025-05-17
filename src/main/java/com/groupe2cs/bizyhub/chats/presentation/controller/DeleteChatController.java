package com.groupe2cs.bizyhub.chats.presentation.controller;

import com.groupe2cs.bizyhub.chats.application.usecase.ChatDeleteApplicationService;
import com.groupe2cs.bizyhub.chats.domain.valueObject.ChatId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@PreAuthorize("@chatGate.canDelete(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/chat")
@Tag(name = "Chat commands", description = "Endpoints for managing chats")
@Slf4j
public class DeleteChatController {

	private final ChatDeleteApplicationService applicationService;

	public DeleteChatController(ChatDeleteApplicationService applicationService) {
		this.applicationService = applicationService;
	}


	@DeleteMapping("/{id}")
	@Operation(
			summary = "Delete a chat",
			description = "Deletes a chat based on the provided identifier"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Chat deleted successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})
	public ResponseEntity<String> deleteChat(
			@Parameter(description = "ID of the chat to delete", required = true)
			@PathVariable String id,
			@AuthenticationPrincipal Jwt jwt
	) {
		if (id == null || id.isEmpty()) {
			return ResponseEntity.badRequest().body("Invalid ID");
		}

		try {
			ChatId idVo = ChatId.create(id);

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
					.build();

			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			applicationService.deleteChat(idVo, metaRequest);

			return ResponseEntity.ok("Chat deleted successfully");
		} catch (Exception e) {
			log.error("Error deleting chat with id {}: {}", id, e.getMessage());
			return ResponseEntity.internalServerError().body("Error deleting chat");
		}
	}
}
