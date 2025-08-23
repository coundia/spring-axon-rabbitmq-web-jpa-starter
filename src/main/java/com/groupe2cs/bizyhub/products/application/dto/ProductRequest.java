package com.groupe2cs.bizyhub.products.application.dto;

import com.groupe2cs.bizyhub.products.domain.valueObject.*;
import java.util.UUID;
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

	@Schema(description = "", example = "5d0d14f3-22db-4da7-8f51-45ba525cd8f5")
	private String remoteId;
	@Schema(description = "", example = "8edd784a-9704-44a4-a0f3-abfed13aae74")
	private String code;
	@Schema(description = "", example = "40538713-de12-42ef-bacb-0edd99c88087")
	private String name;
	@Schema(description = "", example = "04e4396c-61d9-4c9f-aff8-070c9a98a77e")
	private String description;
	@Schema(description = "", example = "b0881a9c-d9a8-4fee-9951-b0c82af06551")
	private String barcode;
	@Schema(description = "", example = "dc641110-4848-4e5b-97b8-f9dd944b8dd1")
	private String unit;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "d8e80246-cc80-458c-a296-a927b9048037")
	private String category;
	@Schema(description = "", example = "7077.68")
	private Double defaultPrice;
	@Schema(description = "", example = "87345985-cef3-40ae-86e4-a9e88a788dcd")
	private String statuses;
	@Schema(description = "", example = "9524.8")
	private Double purchasePrice;

}
