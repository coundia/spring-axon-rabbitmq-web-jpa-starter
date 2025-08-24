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

		@Schema(description = "", example = "06c14280-6f8c-4159-b99d-123e76c1f2df")
		private String code;
		@Schema(description = "", example = "6ffd01c0-7634-4711-966b-204ccc7ab5ca")
		private String name;
		@Schema(description = "", example = "a788a63f-1d92-4956-b7de-973ade21be0e")
		private String remoteId;
		@Schema(description = "", example = "c8a1b34e-1d56-4c04-b094-705635a695bc")
		private String localId;
		@Schema(description = "", example = "af61b38a-21ef-4e73-b310-0108fdc83fee")
		private String description;
		@Schema(description = "", example = "b7c1508e-a8db-4a06-99eb-b5e0d9f03915")
		private String typeEntry;
		@Schema(description = "", example = "90")
		private Integer version;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;

}
