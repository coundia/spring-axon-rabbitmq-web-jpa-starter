package com.groupe2cs.bizyhub.sales.presentation.controller;

	import com.groupe2cs.bizyhub.sales.domain.valueObject.*;

import com.groupe2cs.bizyhub.sales.application.mapper.SaleMapper;
import com.groupe2cs.bizyhub.sales.application.command.UpdateSaleCommand;
import com.groupe2cs.bizyhub.sales.application.dto.SaleRequest;
import com.groupe2cs.bizyhub.sales.application.dto.SaleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/commands/sale")
@Tag(name = "Sale commands", description = "Endpoints for managing sales")
@Slf4j
public class UpdateSaleController {

private final CommandGateway commandGateway;

public UpdateSaleController(CommandGateway commandGateway) {
this.commandGateway = commandGateway;
}

@PutMapping("/{id}")
@Operation(
summary = "Update an existing sale",
description = "Updates an existing sale by ID and returns the updated entity"
)
@ApiResponses(value = {
@ApiResponse(
responseCode = "200",
description = "Sale updated successfully",
content = @Content(mediaType = "application/json", schema = @Schema(implementation = SaleResponse.class))
),
@ApiResponse(
responseCode = "400",
description = "Invalid input data",
content = @Content
),
@ApiResponse(
responseCode = "500",
description = "Internal server error",
content = @Content
)
})
public ResponseEntity<SaleResponse> updateSale(
	@Parameter(description = "The ID of the sale to update", required = true)
	@PathVariable String id,

	@RequestBody
	@io.swagger.v3.oas.annotations.parameters.RequestBody(
	description = "Sale data to update",
	required = true,
	content = @Content(schema = @Schema(implementation = SaleRequest.class))
	)
	SaleRequest saleRequest
	) {
	try {

	UpdateSaleCommand command = SaleMapper.toUpdateCommand(id, saleRequest);

	commandGateway.sendAndWait(command);

	SaleResponse response = SaleMapper.toResponse(id,saleRequest);
	return ResponseEntity.ok(response);
	} catch (Exception e) {
	log.error("Failed to update sale with id {}: {}", id, e.getMessage());
	return ResponseEntity.internalServerError().build();
	}
	}
}
