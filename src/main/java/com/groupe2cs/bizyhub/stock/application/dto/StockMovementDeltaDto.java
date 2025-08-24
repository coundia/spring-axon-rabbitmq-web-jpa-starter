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

		@Schema(description = "", example = "eeeaa065-c082-4e43-bcfe-2dad145ea7b6")
		private String typeStockMovement;
		@Schema(description = "", example = "90")
		private Integer quantity;
		@Schema(description = "", example = "e455de80-bebb-48a7-810a-173618141ae9")
		private String remoteId;
		@Schema(description = "", example = "a97d921a-9bb8-4a91-a2f2-77f8150520d9")
		private String localId;
		@Schema(description = "", example = "0f71b94b-07a9-45d7-933d-fe412661316f")
		private String company;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "d76e47fc-91a9-4d39-957b-610b093083db")
		private String productVariant;
		@Schema(description = "", example = "f153c1e1-e803-497e-a39c-3ff584b918b6")
		private String orderLineId;
		@Schema(description = "", example = "a5c17255-2e74-440d-a210-8c97211e5c45")
		private String discriminator;

}
