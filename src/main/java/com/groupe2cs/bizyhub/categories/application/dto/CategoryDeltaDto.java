package com.groupe2cs.bizyhub.categories.application.dto;

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
@Schema(name = "CategoryDeltaDto", description = "Delta DTO for category changes")
public class CategoryDeltaDto implements Serializable {

    @Schema(description = "Identifier of the category", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "df20b912-418c-4ada-88f7-179905550fcb")
		private String name;
		@Schema(description = "", example = "9ec9c374-42bb-4cdb-beec-af93a3a3d048")
		private String typeCategoryRaw;
		@Schema(description = "", example = "3d0774fa-3d44-485e-b618-c6d6a7bddb7d")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "441fe7bf-7b90-4a11-8ebf-8a49f25faddb")
		private String reference;

}
