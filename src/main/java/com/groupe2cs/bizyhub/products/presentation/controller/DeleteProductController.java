package com.groupe2cs.bizyhub.products.presentation.controller;

	import com.groupe2cs.bizyhub.products.application.mapper.*;
	import com.groupe2cs.bizyhub.products.domain.valueObject.*;
	import com.groupe2cs.bizyhub.products.domain.exception.*;
	import com.groupe2cs.bizyhub.products.application.dto.*;
	import com.groupe2cs.bizyhub.products.application.usecase.*;

import com.groupe2cs.bizyhub.products.application.command.DeleteProductCommand;
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
@RequestMapping("/api/v1/commands/product")
@Tag(name = "Product commands", description = "Endpoints for managing products")
@Slf4j
public class DeleteProductController {

private final ProductDeleteApplicationService applicationService;

public DeleteProductController(ProductDeleteApplicationService applicationService) {
    this.applicationService = applicationService;
}


@DeleteMapping("/{id}")
@Operation(
summary = "Delete a product",
description = "Deletes a product based on the provided identifier"
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Product deleted successfully"),
@ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
})
public ResponseEntity<String> deleteProduct(
	@Parameter(description = "ID of the product to delete", required = true)
	@PathVariable String id
	) {
	if (id == null || id.isEmpty()) {
	return ResponseEntity.badRequest().body("Invalid ID");
	}

	try {
	ProductId idVo = ProductId.create(id);
	applicationService.deleteProduct(idVo);
	return ResponseEntity.ok("Product deleted successfully");
	} catch (Exception e) {
	log.error("Error deleting product with id {}: {}", id, e.getMessage());
	return ResponseEntity.internalServerError().body("Error deleting product");
	}
	}
	}
