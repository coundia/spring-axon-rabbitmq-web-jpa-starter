package com.groupe2cs.bizyhub.accounts.presentation.controller;

import com.groupe2cs.bizyhub.accounts.application.usecase.AccountUserDeleteApplicationService;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.AccountUserId;
import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;
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


@PreAuthorize("@accountUserGate.canDelete(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/accountUser")
@Tag(name = "AccountUser commands", description = "Endpoints for managing accountUsers")
@Slf4j
public class DeleteAccountUserController {

	private final AccountUserDeleteApplicationService applicationService;

	public DeleteAccountUserController(AccountUserDeleteApplicationService applicationService) {
		this.applicationService = applicationService;
	}


	@DeleteMapping("/{id}")
	@Operation(
			summary = "Delete a accountUser",
			description = "Deletes a accountUser based on the provided identifier"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "AccountUser deleted successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	}
	)
	public ResponseEntity<ApiResponseDto> deleteAccountUser(
			@Parameter(description = "ID of the accountUser to delete", required = true)
			@PathVariable String id,
			@AuthenticationPrincipal Jwt jwt
	) {
		if (id == null || id.isEmpty()) {

			return ResponseEntity.badRequest().body(
					ApiResponseDto.builder()
							.code(0)
							.message("Invalid ID supplied")
							.build()
			);
		}

		try {
			AccountUserId idVo = AccountUserId.create(id);

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
					.build();

			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			applicationService.deleteAccountUser(idVo, metaRequest);

			return ResponseEntity.ok(
					ApiResponseDto.builder()
							.code(1)
							.message("accountUser with id " + id + " deleted successfully")
							.build()
			);
		} catch (Exception e) {
			log.error("Error deleting accountUser with id {}: {}", id, e.getMessage());
			return ResponseEntity.internalServerError().body(
					ApiResponseDto.builder()
							.code(0)
							.message(e.getMessage())
							.build()
			);
		}
	}
}
