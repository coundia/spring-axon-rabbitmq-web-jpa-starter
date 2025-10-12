package com.groupe2cs.bizyhub.customers.presentation.controller;

import com.groupe2cs.bizyhub.customers.application.dto.CustomerRequest;
import com.groupe2cs.bizyhub.customers.application.dto.CustomerResponse;
import com.groupe2cs.bizyhub.customers.application.usecase.CustomerUpdateApplicationService;
import com.groupe2cs.bizyhub.customers.domain.valueObject.CustomerId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
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

@PreAuthorize("@customerGate.canEdit(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/customer")
@Tag(name = "Customer commands", description = "Endpoints for managing customers")
@Slf4j
public class UpdateCustomerController {

	private final CustomerUpdateApplicationService applicationService;

	public UpdateCustomerController(CustomerUpdateApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@Operation(summary = "Update a new customer")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Customer Updated",
					content = @Content(mediaType = "application/json",
							schema = @Schema(implementation = CustomerResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content)
	})
	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerResponse> updateCustomer(
			@Valid @PathVariable String id,
			@RequestBody CustomerRequest request,
			@AuthenticationPrincipal Jwt jwt
	) {
		{
			try {

				MetaRequest metaRequest = MetaRequest.builder()
						.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
						.build();

				metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

				CustomerResponse response = applicationService.updateCustomer(CustomerId.create(id),
						request,
						metaRequest
				);

				return ResponseEntity.ok(response);

			} catch (Exception ex) {
				//e.printStackTrace();
				log.error("Failed to Update customer: {}", ex.getMessage(), ex);
				return ResponseEntity.internalServerError().build();
			}
		}
	}
}
