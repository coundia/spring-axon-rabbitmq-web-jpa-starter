package com.groupe2cs.bizyhub.products.application.dto;


import io.swagger.v3.oas.annotations.media.Schema;

public class ProductResponseDTO extends ProductDTO {

    @Schema(description = "UUID of the product", example = "6e0a6735-403b-4868-90a9-a121b659e785")
    public String id;

    public ProductResponseDTO(double price, String name,String id) {
        this.price = price;
        this.name = name;
        this.id=id;
    }

    public static ProductResponseDTO create(double price, String name, String id) {
        return new ProductResponseDTO(price, name,id);
    }
}