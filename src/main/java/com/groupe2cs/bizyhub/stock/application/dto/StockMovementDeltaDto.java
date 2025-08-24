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

		@Schema(description = "", example = "16c914cc-83f5-4f2e-8a7d-e980216120fd")
		private String typeStockMovement;
		@Schema(description = "", example = "53")
		private Integer quantity;
		@Schema(description = "", example = "c496cb60-94da-4696-a018-c34c459eea01")
		private String remoteId;
		@Schema(description = "", example = "e8ab2661-96b6-49d0-9f9a-d0711c472dcf")
		private String company;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "f30c3ecd-5e16-4dba-a7f7-f562a496ea2e")
		private String productVariant;
		@Schema(description = "", example = "2e2812d2-412a-4c9e-b3c5-950fe092e766")
		private String orderLineId;
		@Schema(description = "", example = "3c1a41f9-0519-45c4-85fe-4626d65d4db1")
		private String discriminator;

}
