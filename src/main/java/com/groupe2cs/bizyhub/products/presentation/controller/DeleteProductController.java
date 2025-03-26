package com.groupe2cs.bizyhub.products.presentation.controller;

import com.groupe2cs.bizyhub.products.application.command.DeleteProductCommand;
import com.groupe2cs.bizyhub.products.application.query.FindByIdProductQuery;
import com.groupe2cs.bizyhub.products.domain.exception.ProductNotFoundException;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductId;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/api/v1/commands/products")
public class DeleteProductController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    public DeleteProductController(CommandGateway commandGateway, QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Delete a product by id")
    public CompletableFuture<ResponseEntity<String>> deleteProduct(@PathVariable String id) {
        if (id == null || id.isEmpty()) {
            return CompletableFuture.completedFuture(ResponseEntity.badRequest().body("Invalid id"));
        }

        log.info("Deleting product with id: {}", id);

        ProductId productId = ProductId.create(id);

        return queryGateway.query(new FindByIdProductQuery(productId), Product.class)
                .thenCompose(foundProduct -> {
                    if (foundProduct == null) {
                        throw new ProductNotFoundException("Product not found with id: " + id);
                    }

                    return commandGateway.send(new DeleteProductCommand(productId))
                            .thenApply(result -> ResponseEntity.ok("Product deleted successfully"))
                            .exceptionally(throwable -> {
                                log.error("Error deleting product with id {}: {}", id, throwable.getMessage());
                                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                        .body("Error deleting product: " + throwable.getMessage());
                            });
                })
                .exceptionally(e -> {
                    log.error("Product not found: {}", e.getMessage());
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
                });
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> productNotFoundExceptionHandler(ProductNotFoundException e) {
        log.info("Product not found: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
