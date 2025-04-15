package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.sales.application.dto.SaleRequest;
import com.groupe2cs.bizyhub.sales.application.dto.SaleResponse;
import com.groupe2cs.bizyhub.sales.application.usecase.SaleCreateApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/commands/sale")
@Tag(name = "Sale commands", description = "Endpoints for managing sales")
@Slf4j

public class AddSaleController {

    private final SaleCreateApplicationService applicationService;

    public AddSaleController(SaleCreateApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    @Operation(
            summary = "Create a new sale",
            description = "Creates a new sale and returns the created entity",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Sale request payload",
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
    public ResponseEntity<SaleResponse> addSale(@RequestBody SaleRequest request) {
        try {

            SaleResponse response = applicationService.createSale(request);

            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            log.error("Failed to create sale: {}", ex.getMessage());
            return ResponseEntity.status(500).build();
        }
    }
}
