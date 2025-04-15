package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.sales.application.dto.SaleResponse;
import com.groupe2cs.bizyhub.sales.application.usecase.SaleReadApplicationService;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleProduct;
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
@RequestMapping("/api/v1/queries/sale")
@Tag(name = "Sale Queries", description = "Endpoints for querying sales by Product")
@Slf4j
public class FindByProductSaleController {

    private final SaleReadApplicationService applicationService;

    public FindByProductSaleController(SaleReadApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/by-Product")
    @Operation(
            summary = "Find sale by Product",
            description = "Returns a list of sales that match the given Product"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Query successful",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = SaleResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })

    public ResponseEntity<List<SaleResponse>> findByProduct(
            @Parameter(description = "Value of the Product to filter by", required = true)
            @RequestParam String Product
    ) {
        try {

            var future = applicationService.findBySaleProduct(SaleProduct.create(Product));
            return ResponseEntity.ok(future);
        } catch (Exception e) {
            log.error("Failed to find sale by Product: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }
}