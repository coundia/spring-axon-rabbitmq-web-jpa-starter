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

		@Schema(description = "", example = "55b52e76-6a23-42a0-90ee-fbdc212c1a55")
		private String typeStockMovement;
		@Schema(description = "", example = "30")
		private Integer quantity;
		@Schema(description = "", example = "ca655dac-3e0f-4ccb-bc3b-996fc52f2bfe")
		private String remoteId;
		@Schema(description = "", example = "7fce1511-a7b4-4e7f-b2b4-3602d104fe2d")
		private String localId;
		@Schema(description = "", example = "524ccf9c-abd2-4c74-8580-dd6112528500")
		private String company;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "890c8bf7-5b9b-4600-b807-530bdb0a5da3")
		private String productVariant;
		@Schema(description = "", example = "6295031f-53ae-42aa-8e8f-1190ae65959c")
		private String orderLineId;
		@Schema(description = "", example = "9277dd8b-0533-419e-b6aa-bd92f5d6c3cb")
		private String discriminator;

}
