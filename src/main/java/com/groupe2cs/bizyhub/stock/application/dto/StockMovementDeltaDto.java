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

		@Schema(description = "", example = "168d3d7c-1664-4176-bf24-9aa02bb5d7e1")
		private String typeStockMovement;
		@Schema(description = "", example = "12")
		private Integer quantity;
		@Schema(description = "", example = "9c62b907-9788-45cc-b973-2572de1e97d3")
		private String remoteId;
		@Schema(description = "", example = "b7de0870-d730-4eab-9354-79e9557cbf3e")
		private String localId;
		@Schema(description = "", example = "3ce0bfd1-6276-4481-9990-82f01ca2f1d9")
		private String account;
		@Schema(description = "", example = "6f9a20cb-6241-458a-80e0-e3dd58f96405")
		private String company;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "d36e116b-cfef-4f97-a796-c92320811b56")
		private String productVariant;
		@Schema(description = "", example = "e9d256c1-f6c5-493c-8564-42e2e87026be")
		private String orderLineId;
		@Schema(description = "", example = "13b127b4-c51f-49a2-8af8-fe4d4ceb241d")
		private String discriminator;

}
