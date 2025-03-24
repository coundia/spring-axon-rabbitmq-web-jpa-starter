package com.groupe2cs.bizyhub.products.application.dto;


public class ProductRequestDTO extends ProductDTO {

    public ProductRequestDTO(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public static ProductRequestDTO create(double price, String name) {
        return new ProductRequestDTO(price, name);
    }

}