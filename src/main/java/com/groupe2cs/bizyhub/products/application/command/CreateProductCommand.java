package com.groupe2cs.bizyhub.products.application.command;

import com.groupe2cs.bizyhub.products.domain.valueObject.ProductId;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductName;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductPrice;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProductCommand implements Serializable {
    @TargetAggregateIdentifier
    private ProductId id;
    private ProductName name;
    private ProductPrice price;

    public CreateProductCommand(ProductName name, ProductPrice price) {
        this.id = ProductId.create(UUID.randomUUID().toString());

        this.name = name;
        this.price = price;
    }
}
