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

		@Schema(description = "", example = "a5ce499f-b86f-4f73-9ec3-8ddb43266f58")
		private String remoteId;
		@Schema(description = "", example = "895dcef8-d751-4e0c-acad-917da7d4cf27")
		private String localId;
		@Schema(description = "", example = "16")
		private Integer stockOnHand;
		@Schema(description = "", example = "30")
		private Integer stockAllocated;
		@Schema(description = "", example = "4b4a2175-ce51-4905-ad81-90efe4b953f5")
		private String productVariant;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "4cd5c579-2fbd-4141-90b4-3a5061b665f1")
		private String company;

}
