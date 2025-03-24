package com.groupe2cs.bizyhub.products.application.Mapper;

import com.groupe2cs.bizyhub.products.application.command.CreateProductCommand;
import com.groupe2cs.bizyhub.products.application.dto.ProductRequestDTO;
import com.groupe2cs.bizyhub.products.application.dto.ProductResponseDTO;
import com.groupe2cs.bizyhub.products.domain.aggregate.ProductAggregate;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductName;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductPrice;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;

public class ProductMapper {

    public static ProductAggregate toModel(ProductRequestDTO productRequestDTO) {
        return ProductAggregate.create(ProductPrice.create(productRequestDTO.price), ProductName.create(productRequestDTO.name));
    }

    public static ProductResponseDTO fromModel(ProductAggregate productModel) {
        return ProductResponseDTO.create(productModel.getPrice().value(), productModel.getName().value(), productModel.getId().value());
    }

    public static ProductRequestDTO toRequestDto(ProductAggregate productModel) {
        return new ProductRequestDTO(productModel.getPrice().value(), productModel.getName().value());
    }

    public static CreateProductCommand toCreateCommand(ProductAggregate productModel) {
        return new CreateProductCommand(productModel.getId().value(), productModel.getPrice().value(), productModel.getName().value());
    }

    public static Product toEntity(CreateProductCommand command) {
        return new Product(command.getId(),command.getName(),command.getPrice());
    }
}
