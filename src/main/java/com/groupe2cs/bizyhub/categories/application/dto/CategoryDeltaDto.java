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

		@Schema(description = "", example = "13add40b-9790-4afe-8688-4038307d0c10")
		private String name;
		@Schema(description = "", example = "86787a26-2dd0-4445-9eca-50ac100b313c")
		private String typeCategoryRaw;
		@Schema(description = "", example = "b9347c1c-12a0-42af-9c68-491ac4fbf6aa")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;

}
