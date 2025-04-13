package com.groupe2cs.bizyhub.products.presentation.controller;

import com.groupe2cs.bizyhub.products.application.dto.ProductRequest;
import com.groupe2cs.bizyhub.products.application.dto.ProductResponse;
import com.groupe2cs.bizyhub.products.application.usecase.ProductUpdateApplicationService;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/commands/product")
@Tag(name = "Product commands", description = "Endpoints for managing products")
@Slf4j
public class UpdateProductController {

    private final ProductUpdateApplicationService applicationService;

    public UpdateProductController(ProductUpdateApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Operation(summary = "Update a new product")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Product Updated",
                            content =
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ProductResponse.class))),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error",
                            content = @Content)
            })
    @PutMapping(
            value = "{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable String id, @RequestBody ProductRequest request) {
        {
            try {

                ProductResponse response = applicationService.updateProduct(ProductId.create(id), request);

                return ResponseEntity.ok(response);

            } catch (Exception ex) {
                log.error("Failed to Update product: {}", ex.getMessage(), ex);
                return ResponseEntity.internalServerError().build();
            }
        }
    }
}
