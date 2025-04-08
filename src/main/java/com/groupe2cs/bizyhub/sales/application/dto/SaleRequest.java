package com.groupe2cs.bizyhub.sales.application.dto;

import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "SaleRequest", description = "Request payload for Sale operations")
public class SaleRequest implements Serializable {

	@Schema(description = "", example = "")
	private Integer quantity;
	@Schema(description = "", example = "")
	private Double total_price;

}
