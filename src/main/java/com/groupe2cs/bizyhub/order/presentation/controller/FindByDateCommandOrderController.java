package com.groupe2cs.bizyhub.order.presentation.controller;

import com.groupe2cs.bizyhub.order.application.dto.OrderResponse;
import com.groupe2cs.bizyhub.order.application.usecase.OrderReadApplicationService;
import com.groupe2cs.bizyhub.order.domain.valueObject.OrderDateCommand;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.audit.RequestContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@PreAuthorize("@orderGate.canList(authentication)")
@RestController
@RequestMapping("/api/v1/queries/orders")
@Tag(name = "Order Queries", description = "Endpoints for querying orders by dateCommand")
@Slf4j
public class FindByDateCommandOrderController {

	private final OrderReadApplicationService applicationService;

	public FindByDateCommandOrderController(OrderReadApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@GetMapping("/dateCommand")
	@Operation(
			summary = "Find order by dateCommand",
			description = "Returns a list of orders that match the given dateCommand"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Query successful",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})

	public ResponseEntity<List<OrderResponse>> findByDateCommand(
			@AuthenticationPrincipal Jwt jwt,
			@Parameter(description = "Value of the dateCommand to filter by", required = true)
			@RequestParam java.time.Instant dateCommand
	) {
		try {

			MetaRequest metaRequest = MetaRequest.builder()
					.userId(RequestContext.getUserId(jwt)).tenantId(RequestContext.getTenantId(jwt))
					.build();
			metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

			var future = applicationService.findByOrderDateCommand(OrderDateCommand
					.create(dateCommand), metaRequest);

			return ResponseEntity.ok(future);
		} catch (Exception e) {
			log.error("Failed to find order by dateCommand: {}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}
}