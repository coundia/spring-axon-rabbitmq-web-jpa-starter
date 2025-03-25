package com.groupe2cs.bizyhub.products.application.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class ProductCreatedEvent implements  Serializable {
    private String id;
    private Double price;
    private String name;

    public String toString() {
        return "ProductCreatedEvent{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
