package com.groupe2cs.bizyhub.transactions.presentation.controller;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionItemRequest;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionItemResponse;
import com.groupe2cs.bizyhub.transactions.application.usecase.TransactionItemUpdateApplicationService;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionItemId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("@transactionItemGate.canEdit(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/transactionItem")
@Tag(name = "TransactionItem commands", description = "Endpoints for managing transactionItems")
@Slf4j
public class UpdateTransactionItemController {

	private final TransactionItemUpdateApplicationService applicationService;

	public UpdateTransactionItemController(TransactionItemUpdateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@Operation(summary = "Update a new transactionItem")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "TransactionItem Updated",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = TransactionItemResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content)
	})
	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionItemResponse> updateTransactionItem(
			@Valid @PathVariable String id,
			@RequestBody TransactionItemRequest request,
			@AuthenticationPrincipal Jwt jwt
	) {
		{
			try {

				MetaRequest metaRequest = MetaRequest.builder()
						.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
						.build();

				metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

				TransactionItemResponse
						response =
						applicationService.updateTransactionItem(TransactionItemId.create(id),
								request,
								metaRequest
						);

				return ResponseEntity.ok(response);

			} catch (Exception ex) {
				//e.printStackTrace();
				log.error("Failed to Update transactionItem: {}", ex.getMessage(), ex);
				return ResponseEntity.internalServerError().build();
			}
		}
	}
}
