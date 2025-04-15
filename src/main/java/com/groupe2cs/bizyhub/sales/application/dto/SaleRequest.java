package com.groupe2cs.bizyhub.sales.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "SaleRequest", description = "Request payload for Sale operations")
public class SaleRequest implements Serializable {

    @Schema(description = "", example = "")
    private Integer quantity;
    @Schema(description = "", example = "")
    private Double total_price;
    @Schema(description = "", example = "")
    private String facture;
    @Schema(description = "", example = "")
    private String Product;

    public static SaleRequest random() {
        SaleRequest request = new SaleRequest();
        return request;
    }
}
