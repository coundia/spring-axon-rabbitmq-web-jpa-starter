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

		@Schema(description = "", example = "88d437f2-2443-455e-890c-4e5e459f1560")
		private String code;
		@Schema(description = "", example = "94e63651-de0a-44e8-9677-6b2eb0a51650")
		private String name;
		@Schema(description = "", example = "4f78b034-63dd-49a3-8dd8-9daebf3194f8")
		private String remoteId;
		@Schema(description = "", example = "fc8f32d1-82ca-4484-b55b-f66c4f3f689d")
		private String localId;
		@Schema(description = "", example = "83df2ccb-2e0a-4577-ac7f-9a89cb36febe")
		private String account;
		@Schema(description = "", example = "1fd059f2-8b2f-4ddb-a662-056e37de30d0")
		private String description;
		@Schema(description = "", example = "08d5b49d-8032-4af4-9d9c-7478dda3fba6")
		private String typeEntry;
		@Schema(description = "", example = "41")
		private Integer version;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;

}
