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

		@Schema(description = "", example = "4bf1ad39-3d40-4449-94f2-404e8710ad24")
		private String reference;
		@Schema(description = "", example = "c522965c-eaaf-46b6-a0e9-54031c6b9fab")
		private String name;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "978fdbc4-8a6f-45f8-9c0b-f590677885e8")
		private String typeCategory;
		@Schema(description = "", example = "c273b512-59b1-49df-a552-a04ae6741bbf")
		private String parentId;
		@Schema(description = "", example = "true")
		private Boolean isDefault;
		@Schema(description = "", example = "e70c8749-b873-48fa-bdea-24c64403ff2b")
		private String icon;
		@Schema(description = "", example = "dccdf3a6-4838-4899-9999-1361491f998d")
		private String colorHex;

}
