package com.groupe2cs.bizyhub.products.presentation.controller;

import com.groupe2cs.bizyhub.products.application.command.UpdateNameProductCommand;
import com.groupe2cs.bizyhub.products.application.dto.ProductRequestDTO;
import com.groupe2cs.bizyhub.products.application.query.FindByIdProductQuery;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductId;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductName;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/commands/products")
@Tag(name = "Product Controller", description = "Endpoints for managing products")
@Slf4j
public class UpdateNameProductController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    public UpdateNameProductController(CommandGateway commandGateway, QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @PutMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    @Operation(summary = "Update product name", description = "Updates the name of a product")
    public CompletableFuture<ResponseEntity<String>> updateNameProduct(
            @RequestBody ProductRequestDTO productRequestDTO,
            @PathVariable String id
    ) {
        if (id == null || id.trim().isEmpty()) {
            return CompletableFuture.completedFuture(ResponseEntity.badRequest().body("Invalid product ID"));
        }

        if (productRequestDTO.name == null || productRequestDTO.name.trim().isEmpty()) {
            return CompletableFuture.completedFuture(ResponseEntity.badRequest().body("Product name cannot be empty"));
        }

        log.info("Updating product name: id={}, newName={}", id, productRequestDTO.name);

        ProductId productId = ProductId.create(id);
        ProductName productName = ProductName.create(productRequestDTO.name);

        return queryGateway.query(new FindByIdProductQuery(productId), Product.class)
                .thenCompose(productIdFound -> {
                    if (productIdFound == null) {
                        log.warn("Product not found: id={}", id);
                        return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body("Product not found with id: " + id));
                    }

                    return commandGateway.send(new UpdateNameProductCommand(productId, productName))
                            .thenApply(result -> {
                                log.info("Product updated successfully: id={}", id);
                                return ResponseEntity.ok("Product updated successfully");
                            });
                })
                .exceptionally(e -> {
                    log.error("Error updating product: id={}, error={}", id, e.getMessage());
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body("Error updating product: " + e.getMessage());
                });
    }
}
