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

		@Schema(description = "", example = "58bdecf8-030c-4c48-b960-e86728849b84")
		private String typeStockMovement;
		@Schema(description = "", example = "10")
		private Integer quantity;
		@Schema(description = "", example = "2857684d-b057-4364-b356-c1b46f159eda")
		private String remoteId;
		@Schema(description = "", example = "bb216c0e-5005-46a1-8da8-f11ca4fc4bba")
		private String localId;
		@Schema(description = "", example = "c5de355a-d1b1-45a7-9978-b1ff04bfb393")
		private String company;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "b222c89b-d9b6-4e65-aac6-1131d3b1f2f6")
		private String productVariant;
		@Schema(description = "", example = "be7ad36a-bf8b-496a-8876-c92286ea6ecd")
		private String orderLineId;
		@Schema(description = "", example = "2fa5382e-f1dc-4115-aaa2-d25a525aedb8")
		private String discriminator;

}
