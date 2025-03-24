package com.groupe2cs.bizyhub.products.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;


abstract class ProductDTO implements Serializable {
    @Schema(description = "Name of the product", example = "Laptop")
    public String name;
    @Schema(description = "Price of the product", example = "999.99")
    public double price;

}