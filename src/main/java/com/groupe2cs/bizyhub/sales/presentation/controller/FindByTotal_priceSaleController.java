package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.sales.application.dto.SaleResponse;
import com.groupe2cs.bizyhub.sales.application.usecase.SaleReadApplicationService;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleTotal_price;
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
@Tag(name = "Sale Queries", description = "Endpoints for querying sales by total_price")
@Slf4j
public class FindByTotal_priceSaleController {

    private final SaleReadApplicationService applicationService;

    public FindByTotal_priceSaleController(SaleReadApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/by-total_price")
    @Operation(
            summary = "Find sale by total_price",
            description = "Returns a list of sales that match the given total_price")
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
    public ResponseEntity<List<SaleResponse>> findByTotal_price(
            @Parameter(description = "Value of the total_price to filter by", required = true)
            @RequestParam
            Double total_price) {
        try {

            var future = applicationService.findBySaleTotal_price(SaleTotal_price.create(total_price));
            return ResponseEntity.ok(future);
        } catch (Exception e) {
            log.error("Failed to find sale by total_price: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
