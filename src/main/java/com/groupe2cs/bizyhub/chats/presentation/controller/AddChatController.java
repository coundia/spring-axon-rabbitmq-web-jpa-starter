package com.groupe2cs.bizyhub.chats.presentation.controller;

import com.groupe2cs.bizyhub.chats.application.dto.ChatResponse;
import com.groupe2cs.bizyhub.chats.application.usecase.ChatCreateApplicationService;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@PreAuthorize("@chatGate.canCreate(authentication)")
@RestController
@RequestMapping("/api/v1/commands/chat")
@Tag(name = "Chat commands", description = "Endpoints for managing chats")
@Slf4j
public class AddChatController {

	private final ChatCreateApplicationService applicationService;

	public AddChatController(ChatCreateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@Operation(summary = "Create a new chat")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Chat created",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = ChatResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content)
	})
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ChatResponse> addChat(
			@AuthenticationPrincipal Jwt jwt,
			@RequestPart(value = "files", required = false) List<MultipartFile> files,
			@RequestPart(value = "messages", required = false) String messages,
			@RequestPart(value = "responsesJson", required = false) String responsesJson,
			@RequestPart(value = "responses", required = false) String responses,
			@RequestPart(value = "state", required = false) String state,
			@RequestPart(value = "account", required = false) String account
	) {
		try {

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
					.build();

			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			ChatResponse response = applicationService.createChat(
					files,
					messages,
					responsesJson,
					responses,
					state,
					account,
					metaRequest
			);

			return ResponseEntity.status(HttpStatus.CREATED).body(response);

		} catch (Exception ex) {
			log.error("Failed to create chat: {}", ex.getMessage(), ex);
			return ResponseEntity.internalServerError().build();
		}
	}
}
