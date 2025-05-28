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

		@Schema(description = "", example = "5ff4d9a5-712b-42a0-975d-af03f216873a")
		private String name;
		@Schema(description = "", example = "292e8974-af5b-4296-8b28-c820e712a2d1")
		private String typeCategoryRaw;
		@Schema(description = "", example = "0b403113-3ad3-4136-9668-6a0d5d7f09c9")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;

}
