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
@Schema(name = "StockLevelDeltaDto", description = "Delta DTO for stockLevel changes")
public class StockLevelDeltaDto implements Serializable {

    @Schema(description = "Identifier of the stockLevel", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "aa2ded82-fb32-41b9-a9e4-2d970bec642a")
		private String remoteId;
		@Schema(description = "", example = "6f688edb-b0d7-42ba-9289-86790506b973")
		private String localId;
		@Schema(description = "", example = "40")
		private Integer stockOnHand;
		@Schema(description = "", example = "24")
		private Integer stockAllocated;
		@Schema(description = "", example = "502e4a8e-6365-40a3-8ed2-484e9b9e7daa")
		private String productVariant;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "5061f8f6-3933-4bdc-89fb-bd5e48609e03")
		private String company;

}
