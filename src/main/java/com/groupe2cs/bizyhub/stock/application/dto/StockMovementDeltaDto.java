package com.groupe2cs.bizyhub.stock.application.dto;

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
@Schema(name = "StockMovementDeltaDto", description = "Delta DTO for stockMovement changes")
public class StockMovementDeltaDto implements Serializable {

    @Schema(description = "Identifier of the stockMovement", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "5f28605e-1b48-4930-aeef-98e9728c3957")
		private String typeStockMovement;
		@Schema(description = "", example = "5")
		private Integer quantity;
		@Schema(description = "", example = "4cab35f0-0cc2-42f2-91f2-1d60124b08d3")
		private String company;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "09d08ad0-8fe8-46ea-b264-415c78737150")
		private String productVariant;
		@Schema(description = "", example = "6b9273a3-fb4a-4e35-a778-d5852ee46f71")
		private String orderLineId;
		@Schema(description = "", example = "b495b295-426a-4816-b168-c6285c174328")
		private String discriminator;

}
