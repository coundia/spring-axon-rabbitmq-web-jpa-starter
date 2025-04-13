package com.groupe2cs.bizyhub.sales.application.dto;

	import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

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

public static SaleRequest random() {
SaleRequest request = new SaleRequest();
return request;
}
}
