package com.groupe2cs.bizyhub.products.application.dto;

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
@Schema(name = "ProductResponse", description = "Response payload for Product")
public class ProductResponse implements Serializable {

    @Schema(description = "", example = "")
    private String id;
    @Schema(description = "", example = "")
    private String name;
    @Schema(description = "", example = "")
    private Double price;

}
