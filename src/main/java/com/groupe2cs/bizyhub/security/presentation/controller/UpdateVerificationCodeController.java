package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.usecase.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import lombok.AllArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

@PreAuthorize("@verificationCodeGate.canEdit(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/verificationCode")
@Tag(name = "VerificationCode commands", description = "Endpoints for managing verificationCodes")
@Slf4j
public class UpdateVerificationCodeController {

	private final VerificationCodeUpdateApplicationService applicationService;

	public UpdateVerificationCodeController(VerificationCodeUpdateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@Operation(summary = "Update a new verificationCode")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "VerificationCode Updated",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = VerificationCodeResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content)
	})
	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VerificationCodeResponse> updateVerificationCode(
			@Valid @PathVariable String id,
			@RequestBody VerificationCodeRequest request,
			@AuthenticationPrincipal Jwt jwt
	) {
		{
			try {

				MetaRequest metaRequest = MetaRequest.builder()
						.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
						.build();

				metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

				VerificationCodeResponse
						response =
						applicationService.updateVerificationCode(VerificationCodeId.create(id),
								request,
								metaRequest
						);

				return ResponseEntity.ok(response);

			} catch (Exception ex) {
				//e.printStackTrace();
				log.error("Failed to Update verificationCode: {}", ex.getMessage(), ex);
				return ResponseEntity.internalServerError().build();
			}
		}
	}
}
