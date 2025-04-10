package com.groupe2cs.bizyhub.sales.presentation.controller;


import com.groupe2cs.bizyhub.sales.application.mapper.SaleMapper;
import com.groupe2cs.bizyhub.sales.application.command.CreateSaleCommand;
import com.groupe2cs.bizyhub.sales.application.dto.SaleRequest;
import com.groupe2cs.bizyhub.sales.application.dto.SaleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/commands/sale")
@Tag(name = "Sale commands", description = "Endpoints for managing sales")
@Slf4j
public class AddSaleController {

private final CommandGateway commandGateway;

public AddSaleController(CommandGateway commandGateway) {
this.commandGateway = commandGateway;
}

@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
@Operation(
summary = "Create a new sale",
description = "Creates a new sale with file uploads and returns the created entity",
requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
description = "Sale request payload plus file(s)",
required = true,
content = @Content(schema = @Schema(implementation = SaleRequest.class))
)
)
@ApiResponses(value = {
@ApiResponse(responseCode = "200", description = "Successfully created",
content = @Content(schema = @Schema(implementation = SaleResponse.class))),
@ApiResponse(responseCode = "500", description = "Internal server error",
content = @Content(schema = @Schema()))
})
public ResponseEntity<SaleResponse> addSale(
	@RequestPart("metadata") SaleRequest saleRequest,
		@RequestPart("facture") MultipartFile facture
	) {
	try {
	CreateSaleCommand command = SaleMapper.toCommand(
	saleRequest,
	facture
	);
	String responseId = commandGateway.sendAndWait(command).toString();
	SaleResponse response = SaleMapper.toResponse(responseId, saleRequest);
	return ResponseEntity.ok(response);
	} catch (Exception ex) {
	log.error("Failed to create sale: {}", ex.getMessage());
	return ResponseEntity.status(500).build();
	}
}
}
