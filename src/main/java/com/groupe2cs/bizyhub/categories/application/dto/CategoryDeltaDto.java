package com.groupe2cs.bizyhub.categories.application.dto;

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
@Schema(name = "CategoryDeltaDto", description = "Delta DTO for category changes")
public class CategoryDeltaDto implements Serializable {

    @Schema(description = "Identifier of the category", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "a8bae2a6-92fe-4a3e-8632-cc5bb64acfe4")
		private String code;
		@Schema(description = "", example = "b0aee1c5-fb8a-4ad6-930c-847fd429d575")
		private String name;
		@Schema(description = "", example = "400cb319-ac92-46ba-b38c-3638281abeda")
		private String remoteId;
		@Schema(description = "", example = "8b2a351b-0d6f-4b6a-b1e0-d8061cceeed4")
		private String description;
		@Schema(description = "", example = "6c59d354-280a-4014-9979-79b8aaa1c295")
		private String typeEntry;
		@Schema(description = "", example = "47")
		private Integer version;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;

}
