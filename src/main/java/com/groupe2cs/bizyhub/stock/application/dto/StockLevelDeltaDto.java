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

		@Schema(description = "", example = "7c75be76-8303-48cd-a93f-1d0aaaa89d82")
		private String remoteId;
		@Schema(description = "", example = "510173bc-5465-4589-92b4-1b00d9c9e081")
		private String localId;
		@Schema(description = "", example = "92")
		private Integer stockOnHand;
		@Schema(description = "", example = "55")
		private Integer stockAllocated;
		@Schema(description = "", example = "b2866a82-578c-471d-b107-ea52737c27e5")
		private String productVariant;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "51aeff26-0e9e-4826-820f-b29dfd0baa3f")
		private String company;

}
