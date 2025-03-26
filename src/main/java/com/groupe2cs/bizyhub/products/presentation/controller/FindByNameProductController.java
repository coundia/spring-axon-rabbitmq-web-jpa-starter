package com.groupe2cs.bizyhub.products.presentation.controller;

import com.groupe2cs.bizyhub.products.application.dto.ListProductResponseDTO;
import com.groupe2cs.bizyhub.products.application.query.FindByNameProductsQuery;
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
@RequestMapping("/api/v1/queries/products/name")
public class FindByNameProductController {

    private final QueryGateway queryGateway;

    public FindByNameProductController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    @Operation(description = "Find product by name")
    public CompletableFuture<ResponseEntity<ListProductResponseDTO>> findByNameProduct(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit) {

        Pageable pageable = PageRequest.of(page, limit);

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        CompletableFuture<ListProductResponseDTO> response = queryGateway.query(
                new FindByNameProductsQuery(pageable, name),
                ListProductResponseDTO.class
        );

        return response.thenApply(productResponseDTOList -> {
            if (productResponseDTOList.getProducts().isEmpty()) {
                throw new ProductNotFoundException("No products with '" + name + "' not found");
            }
            return ResponseEntity.ok(productResponseDTOList);
        }).exceptionally(throwable -> {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        });
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> productNotFoundExceptionHandler(ProductNotFoundException e) {
        log.info("Product not found: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}