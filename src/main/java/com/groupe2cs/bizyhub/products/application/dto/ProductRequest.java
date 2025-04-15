package com.groupe2cs.bizyhub.products.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "ProductRequest", description = "Request payload for Product operations")
public class ProductRequest implements Serializable {

    @Schema(description = "", example = "")
    private String name;
    @Schema(description = "", example = "")
    private Double price;

    public static ProductRequest random() {
        ProductRequest request = new ProductRequest();
        return request;
    }
}
