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

		@Schema(description = "", example = "1ffc6861-9232-4c53-907f-806a697238aa")
		private String remoteId;
		@Schema(description = "", example = "b0e26939-e1a2-44b4-82ae-dc93bf47e325")
		private String code;
		@Schema(description = "", example = "674adbda-9255-4cee-8fd8-8f2e593fe174")
		private String name;
		@Schema(description = "", example = "d0e4bfcb-7b87-4c1b-acd0-a6eb33c49e8e")
		private String description;
		@Schema(description = "", example = "b3a8c66d-8438-474b-8bf8-5fe0cccccb2b")
		private String barcode;
		@Schema(description = "", example = "9199baff-9239-45bf-9bea-3ac550ebd53a")
		private String unit;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "7d295f41-9806-4dec-bfde-b1afda3f3227")
		private String category;
		@Schema(description = "", example = "8408.19")
		private Double defaultPrice;
		@Schema(description = "", example = "bde09b11-0da0-4575-9143-3c82400f6210")
		private String statuses;
		@Schema(description = "", example = "9210.08")
		private Double purchasePrice;

}
