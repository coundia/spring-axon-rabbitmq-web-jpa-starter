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
@Tag(name = "Sale Queries", description = "Endpoints for querying s by id")
@Slf4j
public class FindByIdSaleController {

private final SaleReadApplicationService applicationService;

public FindByIdSaleController(SaleReadApplicationService  applicationService) {
	this.applicationService = applicationService;
}

@GetMapping("/by-id")
@Operation(
summary = "Find  by id",
description = "Returns a single s that match the given id"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Query successful",
content = @Content(mediaType = "application/json", schema = @Schema(implementation = SaleResponse.class))),
@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})

public ResponseEntity<SaleResponse> findById(
	@Parameter(description = "Value of the id to filter by", required = true)
	@RequestParam String id
	) {
	try {

	var future = applicationService.findBySaleId(SaleId.create(id));
	return ResponseEntity.ok(future);
	} catch (Exception e) {
	log.error("Failed to find  by id: {}", e.getMessage(), e);
	return ResponseEntity.internalServerError().build();
	}
	}
}