package com.groupe2cs.bizyhub.products.application.dto;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import lombok.ToString;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Schema(name = "ProductDeltaDto", description = "Delta DTO for product changes")
public class ProductDeltaDto implements Serializable {

    @Schema(description = "Identifier of the product", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "2c8f3963-c2cb-47b8-b223-7d68478346e7")
		private String remoteId;
		@Schema(description = "", example = "0536cd1f-66be-409e-bec6-1bc48efc4fba")
		private String code;
		@Schema(description = "", example = "d9db6f77-0e96-48d9-95dd-fa48a4f16438")
		private String name;
		@Schema(description = "", example = "6ba7522c-0d66-497a-b637-e1a552a07535")
		private String description;
		@Schema(description = "", example = "f88a71f9-4f30-4b1f-9d59-52a04538ee57")
		private String barcode;
		@Schema(description = "", example = "c589be11-81f8-44c3-920a-735083f8b06e")
		private String unit;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "56267e3e-baa2-41a8-86c9-37da8319afa6")
		private String category;
		@Schema(description = "", example = "1561.29")
		private Double defaultPrice;
		@Schema(description = "", example = "0e6e988c-afee-45dd-a743-094e445b3ed5")
		private String statuses;
		@Schema(description = "", example = "9104.98")
		private Double purchasePrice;

}
