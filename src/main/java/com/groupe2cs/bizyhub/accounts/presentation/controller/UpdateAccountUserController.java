package com.groupe2cs.bizyhub.accounts.presentation.controller;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.accounts.application.usecase.*;
import com.groupe2cs.bizyhub.accounts.application.dto.*;
import com.groupe2cs.bizyhub.accounts.application.mapper.*;
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

@PreAuthorize("@accountUserGate.canEdit(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/accountUser")
@Tag(name = "AccountUser commands", description = "Endpoints for managing accountUsers")
@Slf4j
public class UpdateAccountUserController {

private final AccountUserUpdateApplicationService applicationService;

public UpdateAccountUserController(AccountUserUpdateApplicationService  applicationService) {
this.applicationService = applicationService;
}

@Operation(summary = "Update a new accountUser")
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "AccountUser Updated",
content = @Content(mediaType = "application/json",
schema = @Schema(implementation = AccountUserResponse.class))),
@ApiResponse(responseCode = "500", description = "Internal server error",
content = @Content)
})
@PutMapping(value="{id}",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<AccountUserResponse> updateAccountUser(
	@Valid @PathVariable String id,
	@RequestBody AccountUserRequest request,
	@AuthenticationPrincipal Jwt jwt
	) { {
	try {

	MetaRequest metaRequest = MetaRequest.builder()
	.userId(RequestContext.getUserId(jwt))		.tenantId(RequestContext.getTenantId(jwt))
	.build();


	AccountUserResponse response = applicationService.updateAccountUser(AccountUserId.create(id),
	request,
	metaRequest
	);

	return ResponseEntity.ok(response);

	} catch (Exception ex) {
	//e.printStackTrace();
	log.error("Failed to Update accountUser: {}", ex.getMessage(), ex);
	return ResponseEntity.internalServerError().build();
	}
	}
}
}
