package com.groupe2cs.bizyhub.products.presentation.controller;

import com.groupe2cs.bizyhub.products.application.dto.ProductResponse;
import com.groupe2cs.bizyhub.products.application.usecase.ProductReadApplicationService;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductPrice;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/queries/product")
@Tag(name = "Product Queries", description = "Endpoints for querying products by price")
@Slf4j
public class FindByPriceProductController {

    private final ProductReadApplicationService applicationService;

    public FindByPriceProductController(ProductReadApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/by-price")
    @Operation(
            summary = "Find product by price",
            description = "Returns a list of products that match the given price")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Query successful",
                            content =
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ProductResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error",
                            content = @Content)
            })
    public ResponseEntity<List<ProductResponse>> findByPrice(
            @Parameter(description = "Value of the price to filter by", required = true) @RequestParam
            Double price) {
        try {

            var future = applicationService.findByProductPrice(ProductPrice.create(price));
            return ResponseEntity.ok(future);
        } catch (Exception e) {
            log.error("Failed to find product by price: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
