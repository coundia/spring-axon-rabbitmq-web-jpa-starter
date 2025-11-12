package com.groupe2cs.bizyhub.order.presentation.controller;

import com.groupe2cs.bizyhub.order.application.dto.OrderRequest;
import com.groupe2cs.bizyhub.order.application.dto.OrderResponse;
import com.groupe2cs.bizyhub.order.application.usecase.OrderCreateApplicationService;
import com.groupe2cs.bizyhub.shared.application.UserResolverService;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("@orderGate.canCreate(authentication)")

@RestController
@RequestMapping("/api/public/add/order")
@Tag(name = "Order commands", description = "Endpoints for managing orders")
@Slf4j
@RequiredArgsConstructor
public class PublicAddOrderController {

	private final CurrentTenantIdentifierResolver currentTenantIdentifierResolver;
	private final OrderCreateApplicationService applicationService;
	private final UserResolverService userResolverService;

	@PostMapping
	@Operation(
			summary = "Create a new order",
			description = "Creates a new order and returns the created entity",
			requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
					description = "Order request payload",
					required = true,
					content = @Content(schema = @Schema(implementation = OrderRequest.class))
			)
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Successfully created",
					content = @Content(schema = @Schema(implementation = OrderResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content(schema = @Schema()))
	})
	public ResponseEntity<OrderResponse> addOrder(@Valid @RequestBody OrderRequest request) {
		try {

			MetaRequest metaRequest = MetaRequest.builder()
					.build();

			metaRequest.setIsAdmin(false);
			String tenantId = currentTenantIdentifierResolver.resolveCurrentTenantIdentifier();
			metaRequest.setTenantId(tenantId);
			metaRequest.setIsPublic(true);
			String userId = userResolverService.resolveUserId(
					request.getIdentifiant(),
					request.getTelephone(),
					request.getMail(),
					request.getIdentifiant()
			);
			metaRequest.setUserId(userId);

			OrderResponse response = applicationService.createOrder(
					request,
					metaRequest
			);

			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (Exception ex) {
			//e.printStackTrace();
			log.error("Failed to create order: {}", ex.getMessage());
			return ResponseEntity.status(500).build();
		}
	}
}
