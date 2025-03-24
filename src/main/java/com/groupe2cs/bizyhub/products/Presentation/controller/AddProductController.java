package com.groupe2cs.bizyhub.products.Presentation.controller;

import com.groupe2cs.bizyhub.products.application.Mapper.ProductMapper;
import com.groupe2cs.bizyhub.products.application.command.CreateProductCommand;
import com.groupe2cs.bizyhub.products.application.dto.ProductRequestDTO;
import com.groupe2cs.bizyhub.products.application.dto.ProductResponseDTO;
import com.groupe2cs.bizyhub.products.domain.aggregate.ProductAggregate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Product Controller", description = "Endpoints for managing products")

public class AddProductController {

    private final CommandGateway commandGateway;

    public AddProductController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/add")
    @Operation(summary = "Add a new product", description = "Creates a new product and returns the created entity")

    public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody ProductRequestDTO productRequestDTO) {

        ProductAggregate product = ProductMapper.toModel(productRequestDTO);
        CreateProductCommand createProductCommand = ProductMapper.toCreateCommand(product);

        commandGateway.send(createProductCommand);

        ProductResponseDTO productResponseDTO = ProductMapper.fromModel(product);
        return ResponseEntity.ok(productResponseDTO);
    }
}
