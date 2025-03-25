package com.groupe2cs.bizyhub.products.application.Mapper;

import com.groupe2cs.bizyhub.products.application.command.CreateProductCommand;
import com.groupe2cs.bizyhub.products.application.dto.ProductRequestDTO;
import com.groupe2cs.bizyhub.products.domain.aggregate.ProductAggregate;

public class ProductMapper {

    public static ProductRequestDTO toRequestDto(ProductAggregate productModel) {
        return new ProductRequestDTO(
                productModel.getPrice().value(),
                productModel.getName().value()
        );
    }

    public static CreateProductCommand toCommand(ProductRequestDTO productRequestDTO) {
        return new CreateProductCommand(
                productRequestDTO.name,
                productRequestDTO.price
        );
    }
}
