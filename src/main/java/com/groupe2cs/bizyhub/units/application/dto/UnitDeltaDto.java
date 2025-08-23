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

		@Schema(description = "", example = "9a3c4708-ab36-4879-85d9-163348ed6814")
		private String remoteId;
		@Schema(description = "", example = "ad606723-72f3-4f0e-a12c-eacb62bed8dd")
		private String code;
		@Schema(description = "", example = "98275bbe-7f99-4e9f-ac9c-9ba4107c3d9d")
		private String name;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "6e5262e1-2f95-4a14-9b57-0311ff8a7e7f")
		private String description;

}
