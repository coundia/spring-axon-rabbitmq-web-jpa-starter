package com.groupe2cs.bizyhub.products.presentation.controller;

import com.groupe2cs.bizyhub.products.application.dto.ProductRequest;
import com.groupe2cs.bizyhub.products.application.dto.ProductResponse;
import com.groupe2cs.bizyhub.products.application.usecase.ProductCreateApplicationService;
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
@RequestMapping("/api/v1/commands/product")
@Tag(name = "Product commands", description = "Endpoints for managing products")
@Slf4j
public class AddProductController {

    private final ProductCreateApplicationService applicationService;

    public AddProductController(ProductCreateApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    @Operation(
            summary = "Create a new product",
            description = "Creates a new product and returns the created entity",
            requestBody =
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Product request payload",
                    required = true,
                    content = @Content(schema = @Schema(implementation = ProductRequest.class))))
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully created",
                            content = @Content(schema = @Schema(implementation = ProductResponse.class))),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error",
                            content = @Content(schema = @Schema()))
            })
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest request) {
        try {

            ProductResponse response = applicationService.createProduct(request);

            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            log.error("Failed to create product: {}", ex.getMessage());
            return ResponseEntity.status(500).build();
        }
    }
}
