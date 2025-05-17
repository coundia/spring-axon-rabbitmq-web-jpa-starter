package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import com.groupe2cs.bizyhub.transactions.application.usecase.TransactionUserDeleteApplicationService;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionUserId;
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


@PreAuthorize("@transactionUserGate.canDelete(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/transactionUser")
@Tag(name = "TransactionUser commands", description = "Endpoints for managing transactionUsers")
@Slf4j
public class DeleteTransactionUserController {

	private final TransactionUserDeleteApplicationService applicationService;

	public DeleteTransactionUserController(TransactionUserDeleteApplicationService applicationService) {
		this.applicationService = applicationService;
	}


	@DeleteMapping("/{id}")
	@Operation(
			summary = "Delete a transactionUser",
			description = "Deletes a transactionUser based on the provided identifier"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "TransactionUser deleted successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})
	public ResponseEntity<String> deleteTransactionUser(
			@Parameter(description = "ID of the transactionUser to delete", required = true)
			@PathVariable String id,
			@AuthenticationPrincipal Jwt jwt
	) {
		if (id == null || id.isEmpty()) {
			return ResponseEntity.badRequest().body("Invalid ID");
		}

		try {
			TransactionUserId idVo = TransactionUserId.create(id);

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
					.build();

			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			applicationService.deleteTransactionUser(idVo, metaRequest);

			return ResponseEntity.ok("TransactionUser deleted successfully");
		} catch (Exception e) {
			log.error("Error deleting transactionUser with id {}: {}", id, e.getMessage());
			return ResponseEntity.internalServerError().body("Error deleting transactionUser");
		}
	}
}
