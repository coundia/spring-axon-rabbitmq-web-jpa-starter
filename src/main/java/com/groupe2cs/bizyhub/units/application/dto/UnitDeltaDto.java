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

		@Schema(description = "", example = "d2c6ac14-e4a4-4492-a0a4-072311f782c2")
		private String remoteId;
		@Schema(description = "", example = "c3707cf2-55cd-48fd-8c96-bb345815df42")
		private String code;
		@Schema(description = "", example = "9916a718-3d85-444b-be82-35c73beecf16")
		private String name;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "c67e0ae0-864e-4ca2-a328-0f0304c529de")
		private String description;

}
