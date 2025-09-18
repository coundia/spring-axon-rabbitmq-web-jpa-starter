package com.groupe2cs.bizyhub.order.presentation.controller;

import com.groupe2cs.bizyhub.order.domain.valueObject.*;
import com.groupe2cs.bizyhub.order.application.usecase.*;
import com.groupe2cs.bizyhub.order.application.dto.*;
import com.groupe2cs.bizyhub.order.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.ApiResponseDto;
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

@PreAuthorize("@orderGate.canEdit(authentication, #id)")
@RestController
@RequestMapping("/api/v1/commands/order")
@Tag(name = "Order commands", description = "Endpoints for managing orders")
@Slf4j
public class UpdateOrderController {

private final OrderUpdateApplicationService applicationService;

public UpdateOrderController(OrderUpdateApplicationService  applicationService) {
this.applicationService = applicationService;
}

@Operation(summary = "Update a new order")
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Order Updated",
content = @Content(mediaType = "application/json",
schema = @Schema(implementation = OrderResponse.class))),
@ApiResponse(responseCode = "500", description = "Internal server error",
content = @Content)
})
@PutMapping(value="{id}",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<?> updateOrder(
	@Valid @PathVariable String id,
	@RequestBody OrderRequest request,
	@AuthenticationPrincipal Jwt jwt
	) { {
	try {

	MetaRequest metaRequest = MetaRequest.builder()
	.userId(RequestContext.getUserId(jwt))		.tenantId(RequestContext.getTenantId(jwt))
	.build();

    metaRequest.setIsAdmin(RequestContext.isAdmin(jwt));

	OrderResponse response = applicationService.updateOrder(OrderId.create(id),
	request,
	metaRequest
	);

	return ResponseEntity.ok(response);

	} catch (Exception ex) {
	//e.printStackTrace();
	log.error("Failed to Update order: {}", ex.getMessage(), ex);
		return ResponseEntity.internalServerError().body(
				ApiResponseDto.builder()
						.code(0)
						.message( ex.getMessage())
						.build()
		);
	}
	}
}
}
