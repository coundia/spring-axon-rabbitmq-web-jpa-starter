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

		@Schema(description = "", example = "202cbbe6-1674-45fd-9b36-a0b98b3d3c8b")
		private String code;
		@Schema(description = "", example = "7902800c-6d4b-41c9-9658-539c0f242673")
		private String name;
		@Schema(description = "", example = "50667f39-867a-4d34-9c77-3c2f98269612")
		private String remoteId;
		@Schema(description = "", example = "62f5c2c4-854f-42ab-baf0-77b9789c53d9")
		private String localId;
		@Schema(description = "", example = "1bf0368f-18b1-4db5-833f-6aa375c58650")
		private String description;
		@Schema(description = "", example = "14ad4258-7895-49a9-bc79-03b8db325bb9")
		private String typeEntry;
		@Schema(description = "", example = "71")
		private Integer version;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;

}
