package com.groupe2cs.bizyhub.units.application.dto;

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
@Schema(name = "UnitDeltaDto", description = "Delta DTO for unit changes")
public class UnitDeltaDto implements Serializable {

    @Schema(description = "Identifier of the unit", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "15e615c8-dce8-4292-b505-9b5eab95dfb9")
		private String remoteId;
		@Schema(description = "", example = "b8ce3e9e-2d97-4afa-a539-6b7c602fc143")
		private String localId;
		@Schema(description = "", example = "8eb4361e-e261-468f-84e2-c850e20db3d1")
		private String code;
		@Schema(description = "", example = "58a6cd9a-3199-4fb9-9dd8-c7a445fe57d8")
		private String name;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "ed8b39a8-3d87-4b98-a017-34466a539927")
		private String description;

}
