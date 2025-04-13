package com.groupe2cs.bizyhub.products.application.dto;

	import com.groupe2cs.bizyhub.products.domain.valueObject.*;
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
