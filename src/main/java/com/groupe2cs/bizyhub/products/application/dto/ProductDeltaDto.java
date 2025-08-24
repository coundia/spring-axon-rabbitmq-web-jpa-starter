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

		@Schema(description = "", example = "1100664e-b109-4c6d-82b6-aa3001b03e5f")
		private String remoteId;
		@Schema(description = "", example = "b9a53049-b476-4ab8-875d-d533baf36216")
		private String localId;
		@Schema(description = "", example = "36af6c7d-06d8-422d-9378-02d2b9aaf2a9")
		private String code;
		@Schema(description = "", example = "f889df68-5315-44ba-8a75-e13193c9a9c1")
		private String name;
		@Schema(description = "", example = "b572d672-2d85-489e-a8ff-d85a6ec4aad3")
		private String description;
		@Schema(description = "", example = "82fde97f-ae58-4dd9-9a02-7109e02a8782")
		private String barcode;
		@Schema(description = "", example = "198725df-bbf4-4e66-81ab-3ccb1b31819e")
		private String unit;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "fc7361eb-5030-4407-8fa2-c02f823edd1c")
		private String category;
		@Schema(description = "", example = "9688.14")
		private Double defaultPrice;
		@Schema(description = "", example = "3339194b-99ee-489c-979b-7887c2330e46")
		private String statuses;
		@Schema(description = "", example = "6678.6")
		private Double purchasePrice;

}
