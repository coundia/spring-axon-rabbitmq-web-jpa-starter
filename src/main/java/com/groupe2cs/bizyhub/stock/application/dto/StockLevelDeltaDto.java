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

		@Schema(description = "", example = "6f61ed3a-a018-413b-8d61-ae4b8d069d5f")
		private String remoteId;
		@Schema(description = "", example = "10e1955a-b4ea-4f03-a1b8-9289e800be28")
		private String localId;
		@Schema(description = "", example = "3")
		private Integer stockOnHand;
		@Schema(description = "", example = "55")
		private Integer stockAllocated;
		@Schema(description = "", example = "08149679-15c1-4b06-9126-1d557d033f3c")
		private String account;
		@Schema(description = "", example = "d6463564-8705-4f44-b66a-930f95f81df6")
		private String productVariant;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "a668745c-5368-4d0a-9add-6349d2bb9347")
		private String company;

}
