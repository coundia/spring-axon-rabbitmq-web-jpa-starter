package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.sales.application.dto.SaleResponse;
import com.groupe2cs.bizyhub.sales.application.usecase.SaleReadApplicationService;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleQuantity;
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
@Tag(name = "Sale Queries", description = "Endpoints for querying sales by quantity")
@Slf4j
public class FindByQuantitySaleController {

    private final SaleReadApplicationService applicationService;

    public FindByQuantitySaleController(SaleReadApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/by-quantity")
    @Operation(
            summary = "Find sale by quantity",
            description = "Returns a list of sales that match the given quantity")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Query successful",
                            content =
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = SaleResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid parameter", content = @Content),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error",
                            content = @Content)
            })
    public ResponseEntity<List<SaleResponse>> findByQuantity(
            @Parameter(description = "Value of the quantity to filter by", required = true) @RequestParam
            Integer quantity) {
        try {

            var future = applicationService.findBySaleQuantity(SaleQuantity.create(quantity));
            return ResponseEntity.ok(future);
        } catch (Exception e) {
            log.error("Failed to find sale by quantity: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
