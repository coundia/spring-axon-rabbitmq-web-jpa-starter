package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.sales.application.query.*;
import com.groupe2cs.bizyhub.sales.application.mapper.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.application.usecase.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf;
import static org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf;

@RestController
@RequestMapping("/api/v1/queries/")
@Tag(name = "Sale Queries", description = "Endpoints for querying s by quantity")
@Slf4j
public class FindByQuantitySaleController {

private final SaleReadApplicationService applicationService;

public FindByQuantitySaleController(SaleReadApplicationService  applicationService) {
	this.applicationService = applicationService;
}

@GetMapping("/by-quantity")
@Operation(
summary = "Find  by quantity",
description = "Returns a list of s that match the given quantity"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Query successful",
content = @Content(mediaType = "application/json", schema = @Schema(implementation = SaleResponse.class))),
@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})

public ResponseEntity<List<SaleResponse>> findByQuantity(
	@Parameter(description = "Value of the quantity to filter by", required = true)
	@RequestParam Integer quantity
	) {
	try {

	var future = applicationService.findBySaleQuantity(SaleQuantity.create(quantity));
	return ResponseEntity.ok(future);
	} catch (Exception e) {
	log.error("Failed to find  by quantity: {}", e.getMessage(), e);
	return ResponseEntity.internalServerError().build();
	}
	}
}