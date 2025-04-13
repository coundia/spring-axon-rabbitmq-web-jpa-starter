package com.groupe2cs.bizyhub.sales.presentation.controller;

import com.groupe2cs.bizyhub.sales.application.dto.SaleResponse;
import com.groupe2cs.bizyhub.sales.application.usecase.SaleUpdateApplicationService;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleId;
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
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/commands/sale")
@Tag(name = "Sale commands", description = "Endpoints for managing sales")
@Slf4j
public class UpdateSaleController {

    private final SaleUpdateApplicationService applicationService;

    public UpdateSaleController(SaleUpdateApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Operation(summary = "Update a new sale")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Sale Updated",
                            content =
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = SaleResponse.class))),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal server error",
                            content = @Content)
            })
    @PutMapping(
            value = "{id}",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SaleResponse> addSale(
            @PathVariable String id,
            @RequestPart("facture") MultipartFile facture,
            @RequestParam("quantity") Integer quantity,
            @RequestParam("totalPrice") Double totalPrice) {
        try {
            SaleResponse response =
                    applicationService.updateSale(SaleId.create(id), facture, quantity, totalPrice);

            return ResponseEntity.ok(response);

        } catch (Exception ex) {
            log.error("Failed to Update sale: {}", ex.getMessage(), ex);
            return ResponseEntity.internalServerError().build();
        }
    }
}
