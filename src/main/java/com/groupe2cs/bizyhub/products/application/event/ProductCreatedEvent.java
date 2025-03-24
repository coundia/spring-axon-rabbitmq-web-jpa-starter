package com.groupe2cs.bizyhub.products.application.event;

import com.groupe2cs.bizyhub.products.domain.event.ProductCreatedEventInterface;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductCreatedEvent implements ProductCreatedEventInterface {
    private String id;
    private Double price;
    private String name;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Double getPrice() {
        return price;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ProductCreatedEvent{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
