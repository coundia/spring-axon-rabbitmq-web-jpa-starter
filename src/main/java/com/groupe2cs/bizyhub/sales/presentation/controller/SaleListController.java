package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.sales.application.dto.SalePagedResponse;
import com.groupe2cs.bizyhub.sales.application.usecase.SaleReadApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/queries/list-sale")
@Tag(name = "Sale Queries", description = "Endpoints for listing paginated sales")
public class SaleListController {

    private final SaleReadApplicationService applicationService;

    public SaleListController(SaleReadApplicationService applicationService) {
        this.applicationService = applicationService;
    }


    @GetMapping
    @Operation(
            summary = "List paginated sales",
            description = "Returns a paginated list of sales based on page and limit parameters"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully retrieved list of sales",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = SalePagedResponse.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content
            )
    })
    public SalePagedResponse list(
            @Parameter(description = "Page number (zero-based index)", example = "0")
            @RequestParam(defaultValue = "0") int page,

            @Parameter(description = "Number of items per page", example = "10")
            @RequestParam(defaultValue = "10") int limit
    ) {
        return applicationService.findAll(page, limit);
    }
}
