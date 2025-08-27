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

		@Schema(description = "", example = "1ac327ea-2f41-40f1-a77e-4a417f2696c1")
		private String remoteId;
		@Schema(description = "", example = "46eceb7d-2817-40c2-a796-22ce423e25c1")
		private String localId;
		@Schema(description = "", example = "53f28396-2f2f-43c4-aba9-8f6b37eebe5e")
		private String code;
		@Schema(description = "", example = "e27cc649-7cf4-4b0b-a379-747719b8e4da")
		private String name;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "e8c95a78-7341-42c2-ae35-279d014bfd17")
		private String description;

}
