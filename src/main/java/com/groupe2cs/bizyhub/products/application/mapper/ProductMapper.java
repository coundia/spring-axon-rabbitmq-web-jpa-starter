package com.groupe2cs.bizyhub.products.application.mapper;

import com.groupe2cs.bizyhub.products.application.command.CreateProductCommand;
import com.groupe2cs.bizyhub.products.application.command.DeleteProductCommand;
import com.groupe2cs.bizyhub.products.application.command.UpdateProductCommand;
import com.groupe2cs.bizyhub.products.application.dto.ProductRequest;
import com.groupe2cs.bizyhub.products.application.dto.ProductResponse;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductId;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductName;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductPrice;
import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;


public class ProductMapper {

    public static ProductResponse toResponse(Product entity) {
        return new ProductResponse(
                entity.getId(),
                entity.getName(),
                entity.getPrice()
        );
    }

    public static ProductResponse toResponse(CreateProductCommand command) {
        return new ProductResponse(
                command.getId().value(), command.getName().value(), command.getPrice().value()
        );
    }

    public static ProductResponse toResponse(UpdateProductCommand command) {
        return new ProductResponse(
                command.getId().value(), command.getName().value(), command.getPrice().value()
        );
    }


    public static CreateProductCommand toCommand(
            ProductRequest request
    ) {
        return new CreateProductCommand(
                ProductName.create(request.getName()), ProductPrice.create(request.getPrice())
        );
    }

    public static UpdateProductCommand toUpdateCommand(ProductId id, ProductRequest request) {
        return new UpdateProductCommand(
                id, ProductName.create(request.getName()), ProductPrice.create(request.getPrice())
        );
    }


    public static DeleteProductCommand toDeleteCommand(ProductId id) {
        return new DeleteProductCommand(id);
    }
}
