package com.groupe2cs.bizyhub.sales.presentation.controller;

	import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
	import com.groupe2cs.bizyhub.sales.application.query.*;

import com.groupe2cs.bizyhub.sales.application.query.FindByIdSaleQuery;
import com.groupe2cs.bizyhub.sales.application.dto.SaleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.axonframework.messaging.responsetypes.ResponseTypes.instanceOf;
import static org.axonframework.messaging.responsetypes.ResponseTypes.multipleInstancesOf;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/queries/sale")
@Tag(name = "Sale Queries", description = "Endpoints for querying sales by id")
@Slf4j
public class FindByIdSaleController {

private final QueryGateway queryGateway;

public FindByIdSaleController(QueryGateway queryGateway) {
this.queryGateway = queryGateway;
}

@GetMapping("/by-id")
@Operation(
summary = "Find sale by id",
description = "Returns a list of sales that match the given id"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "List of matching sales",
content = @Content(mediaType = "application/json", schema = @Schema(implementation = SaleResponse.class))),
@ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})
public ResponseEntity<SaleResponse> findById(
@Parameter(description = "Value of the id to filter by", required = true)
@RequestParam String id
) {
try {
	SaleId value = SaleId.create(id);
	FindByIdSaleQuery query = new FindByIdSaleQuery(value);
	CompletableFuture<SaleResponse> future = queryGateway.query(query, instanceOf(SaleResponse.class));
	SaleResponse response = future.join();
	return ResponseEntity.ok(response);
	} catch (Exception e) {
	log.error("Failed to find sale by id: {}", e.getMessage());
	return ResponseEntity.internalServerError().build();
}
}
}
