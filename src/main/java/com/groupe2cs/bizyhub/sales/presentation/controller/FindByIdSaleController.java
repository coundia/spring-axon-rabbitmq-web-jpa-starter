package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.sales.application.dto.SaleResponse;
import com.groupe2cs.bizyhub.sales.application.usecase.SaleReadApplicationService;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleId;
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

@RestController
@RequestMapping("/api/v1/queries/sale")
@Tag(name = "Sale Queries", description = "Endpoints for querying sales by id")
@Slf4j
public class FindByIdSaleController {

    private final SaleReadApplicationService applicationService;

    public FindByIdSaleController(SaleReadApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/by-id")
    @Operation(
            summary = "Find sale by id",
            description = "Returns a single sales that match the given id")
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
    public ResponseEntity<SaleResponse> findById(
            @Parameter(description = "Value of the id to filter by", required = true) @RequestParam
            String id) {
        try {

            var future = applicationService.findBySaleId(SaleId.create(id));
            return ResponseEntity.ok(future);
        } catch (Exception e) {
            log.error("Failed to find sale by id: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
