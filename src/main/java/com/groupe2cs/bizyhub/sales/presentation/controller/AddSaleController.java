package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.sales.application.usecase.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/commands/sale")
@Tag(name = "Sale commands", description = "Endpoints for managing sales")
@Slf4j
public class AddSaleController {

private final SaleCreateApplicationService applicationService;

public AddSaleController(SaleCreateApplicationService  applicationService) {
	this.applicationService = applicationService;
}

@Operation(summary = "Create a new sale")
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Sale created",
content = @Content(mediaType = "application/json",
schema = @Schema(implementation = SaleResponse.class))),
@ApiResponse(responseCode = "500", description = "Internal server error",
content = @Content)
})
@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<SaleResponse> addSale(
		@RequestPart("facture") MultipartFile facture,
			@RequestParam("quantity") Integer quantity,
			@RequestParam("totalPrice") Double totalPrice
	) {
	try {
	SaleResponse response = applicationService.createSale(
	facture,
		quantity,
		totalPrice	);

	return ResponseEntity.ok(response);

	} catch (Exception ex) {
	log.error("Failed to create sale: {}", ex.getMessage(), ex);
	return ResponseEntity.internalServerError().build();
	}
	}
	}
