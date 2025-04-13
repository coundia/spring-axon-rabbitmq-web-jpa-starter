package com.groupe2cs.bizyhub.sales.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "SaleResponse", description = "Response payload for Sale")
public class SaleResponse implements Serializable {

    @Schema(description = "", example = "")
    private String id;

    @Schema(description = "", example = "")
    private Integer quantity;

    @Schema(description = "", example = "")
    private Double total_price;

    @Schema(description = "", example = "")
    private String facture;
}
