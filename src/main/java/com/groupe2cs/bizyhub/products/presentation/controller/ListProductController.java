package com.groupe2cs.bizyhub.products.presentation.controller;

import com.groupe2cs.bizyhub.products.application.dto.ListProductResponseDTO;
import com.groupe2cs.bizyhub.products.application.query.ListProductsQuery;
import com.groupe2cs.bizyhub.products.domain.exception.ProductNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/api/v1/queries/products")
public class ListProductController {

    private final QueryGateway queryGateway;

    public ListProductController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("")
    @Operation(description = "List all products")
    public CompletableFuture<ResponseEntity<ListProductResponseDTO>> listProduct(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit) {

        Pageable pageable = PageRequest.of(page, limit);

        CompletableFuture<ListProductResponseDTO> response = queryGateway.query(
                new ListProductsQuery(pageable),
                ListProductResponseDTO.class
        );

        return response.thenApply(productResponseDTOList -> {
            if (productResponseDTOList.getProducts().isEmpty()) {
                throw new ProductNotFoundException("No products found");
            }
            return ResponseEntity.ok(productResponseDTOList);
        }).exceptionally(throwable -> {
            log.error("Error listing products: {}", throwable.getMessage(), throwable);
            if (throwable.getCause() instanceof ProductNotFoundException) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        });
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> productNotFoundExceptionHandler(ProductNotFoundException e) {
        log.info("Product not found: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> genericExceptionHandler(Exception e) {
        log.error("Unexpected error: {}", e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
    }
}