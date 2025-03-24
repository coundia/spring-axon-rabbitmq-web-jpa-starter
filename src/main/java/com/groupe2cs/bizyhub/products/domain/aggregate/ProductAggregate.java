package com.groupe2cs.bizyhub.products.domain.aggregate;

import com.groupe2cs.bizyhub.products.domain.valueObject.ProductId;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductName;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductPrice;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
public class ProductAggregate {
    @AggregateIdentifier
    private  ProductId id;
    private  ProductPrice price;
    private  ProductName name;
    private  Boolean isDeleted;

    protected ProductAggregate() {}

    public ProductAggregate(ProductId id, ProductPrice price, ProductName name, Boolean isDeleted) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.isDeleted = isDeleted;
    }

    public static ProductAggregate create(ProductPrice price, ProductName name) {
        return new ProductAggregate(ProductId.create(UUID.randomUUID().toString()), price, name, false);
    }

    public ProductId getId() {
        return id;
    }

    public ProductPrice getPrice() {
        return price;
    }

    public ProductName getName() {
        return name;
    }

    public Boolean isDeleted() {
        return isDeleted;
    }

    public ProductAggregate markAsDeleted() {
        return new ProductAggregate(this.id, this.price, this.name, true);
    }
}
