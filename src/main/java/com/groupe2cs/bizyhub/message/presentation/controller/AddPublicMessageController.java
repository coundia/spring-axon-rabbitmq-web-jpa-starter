package com.groupe2cs.bizyhub.message.presentation.controller;

import com.groupe2cs.bizyhub.message.application.usecase.*;
import com.groupe2cs.bizyhub.message.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.shared.application.NotificationService;
import com.groupe2cs.bizyhub.shared.application.UserResolverService;
import com.groupe2cs.bizyhub.shared.domain.MailSender;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import lombok.RequiredArgsConstructor;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/public/messages")
@Tag(name = "Add Message commands", description = "Endpoints for managing messages")
@Slf4j
@RequiredArgsConstructor
public class AddPublicMessageController {

	private final MessageCreateApplicationService applicationService;
	private final UserResolverService userResolverService;
	private final CurrentTenantIdentifierResolver currentTenantIdentifierResolver;

	private final MailSender mailSender;

	@Value("${app.email.to:contact@pcoundia.com}")
	private String to;


	@PostMapping
	@Operation(
			summary = "Create a new message",
			description = "Creates a new message and returns the created entity",
			requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
					description = "Message request payload",
					required = true,
					content = @Content(schema = @Schema(implementation = MessageRequest.class))
			)
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Successfully created",
					content = @Content(schema = @Schema(implementation = MessageResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content(schema = @Schema()))
	})
	public ResponseEntity<MessageResponse> addMessage(@Valid @RequestBody MessageRequest request,
													  @AuthenticationPrincipal Jwt jwt) {
		try {

			log.info("received request to create message: {}", request);

			String userId = userResolverService.resolveUserId(null, null, null,null);

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(userId)
					.tenantId(currentTenantIdentifierResolver.resolveCurrentTenantIdentifier())
					.build();


			MessageResponse response = applicationService.createMessage(
					request,
					metaRequest
			);

			mailSender.send(

					"no-reply@pcoundia.com",
					to,
					request.getCode()+" "+request.getPlateforme()+" "+request.getEmail(),
					"<h1>New Message Received</h1><p>"+request.getContent()+"</p>"+
							"<p>From: "+request.getEmail()+"</p>"

			);

			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error("Failed to create message: {}", ex.getMessage());
			return ResponseEntity.status(500).build();
		}
	}
}
