package com.groupe2cs.bizyhub.sales.application.dto;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "SaleUserDeltaDto", description = "Delta DTO for saleUser changes")
public class SaleUserDeltaDto implements Serializable {

    @Schema(description = "Identifier of the saleUser", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "75a286ba-8ec5-4bc4-b517-0b932994653f")
		private String name;
		@Schema(description = "", example = "aba1c618-b522-4cb3-8724-3ab9df5a52ad")
		private String sales;
		@Schema(description = "", example = "f6c1340d-37af-4c90-9480-205b86de73fe")
		private String users;
		@Schema(description = "", example = "cb041dcb-0e84-43a7-88df-0907b78f7eb4")
		private String username;
		@Schema(description = "", example = "94237d7a-5b24-4f4f-aa1e-32f9025ec0c3")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "86074653-512b-4707-be8d-0c301a016c9e")
		private String reference;

}
