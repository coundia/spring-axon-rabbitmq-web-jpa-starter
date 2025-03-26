package com.groupe2cs.bizyhub.products.presentation.controller;

import com.groupe2cs.bizyhub.products.application.dto.ProductResponseDTO;
import com.groupe2cs.bizyhub.products.application.query.ListProductsQuery;
import com.groupe2cs.bizyhub.products.domain.exception.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/api/v1/queries/products")
public class ListProductController {

    private final QueryGateway queryGateway;

    public ListProductController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<List<ProductResponseDTO>>> listProduct(
            @RequestParam Map<String, String> filters,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);

        CompletableFuture<List<ProductResponseDTO>> response = queryGateway.query(
                new ListProductsQuery(filters, pageable),
                ResponseTypes.multipleInstancesOf(ProductResponseDTO.class)
        );

        return response.thenApply(productResponseDTOList -> {
            if (productResponseDTOList.isEmpty()) {
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