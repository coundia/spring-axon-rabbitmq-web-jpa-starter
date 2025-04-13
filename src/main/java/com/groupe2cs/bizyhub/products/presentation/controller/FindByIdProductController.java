package com.groupe2cs.bizyhub.products.presentation.controller;

import com.groupe2cs.bizyhub.products.application.dto.ProductResponse;
import com.groupe2cs.bizyhub.products.application.usecase.ProductReadApplicationService;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductId;
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
@RequestMapping("/api/v1/queries/product")
@Tag(name = "Product Queries", description = "Endpoints for querying products by id")
@Slf4j
public class FindByIdProductController {

    private final ProductReadApplicationService applicationService;

    public FindByIdProductController(ProductReadApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/by-id")
    @Operation(
            summary = "Find product by id",
            description = "Returns a single products that match the given id")
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
    public ResponseEntity<ProductResponse> findById(
            @Parameter(description = "Value of the id to filter by", required = true) @RequestParam
            String id) {
        try {

            var future = applicationService.findByProductId(ProductId.create(id));
            return ResponseEntity.ok(future);
        } catch (Exception e) {
            log.error("Failed to find product by id: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
