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

		@Schema(description = "", example = "50959cad-1a3f-41bf-85de-0c22af185ea3")
		private String remoteId;
		@Schema(description = "", example = "fba056d0-e9d9-43de-84a3-a8fa3b97f1d1")
		private String localId;
		@Schema(description = "", example = "d04e869e-47da-4cc5-949c-294370c415a1")
		private String code;
		@Schema(description = "", example = "24af9f18-93bd-4da7-93bc-9e67b1c89c07")
		private String name;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "979ccc78-d077-4ea1-8198-a933c4c71706")
		private String description;

}
