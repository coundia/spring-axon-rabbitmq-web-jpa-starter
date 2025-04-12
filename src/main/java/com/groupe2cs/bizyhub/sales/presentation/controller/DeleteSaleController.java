package com.groupe2cs.bizyhub.sales.presentation.controller;

	import com.groupe2cs.bizyhub.sales.application.mapper.*;
	import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
	import com.groupe2cs.bizyhub.sales.domain.exception.*;
	import com.groupe2cs.bizyhub.sales.application.dto.*;
	import com.groupe2cs.bizyhub.sales.application.usecase.*;

import com.groupe2cs.bizyhub.sales.application.command.DeleteSaleCommand;
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
public class DeleteSaleController {

private final SaleDeleteApplicationService applicationService;

public DeleteSaleController(SaleDeleteApplicationService applicationService) {
    this.applicationService = applicationService;
}


@DeleteMapping("/{id}")
@Operation(
summary = "Delete a sale",
description = "Deletes a sale based on the provided identifier"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Sale deleted successfully"),
@ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})
public ResponseEntity<String> deleteSale(
	@Parameter(description = "ID of the sale to delete", required = true)
	@PathVariable String id
	) {
	if (id == null || id.isEmpty()) {
	return ResponseEntity.badRequest().body("Invalid ID");
	}

	try {
	SaleId idVo = SaleId.create(id);
	applicationService.deleteSale(idVo);
	return ResponseEntity.ok("Sale deleted successfully");
	} catch (Exception e) {
	log.error("Error deleting sale with id {}: {}", id, e.getMessage());
	return ResponseEntity.internalServerError().body("Error deleting sale");
	}
	}
	}
