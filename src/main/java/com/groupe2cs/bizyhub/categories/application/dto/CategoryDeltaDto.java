package com.groupe2cs.bizyhub.categories.application.dto;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

import lombok.*;
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

		@Schema(description = "", example = "0fd014c6-5ec4-4b4f-a76b-ae73af5bb3b9")
		private String code;
		@Schema(description = "", example = "886463a5-6b8b-4fd9-9447-8e9fec4aca01")
		private String name;
		@Schema(description = "", example = "66a3ded2-d89d-4bb8-87ab-ae553170fd66")
		private String remoteId;
		@Schema(description = "", example = "378642a1-8a43-47cb-bf91-7cfb8f552eff")
		private String description;
		@Schema(description = "", example = "f8ed4830-eebb-4aa9-bd64-e9722db8f28c")
		private String typeEntry;
		@Schema(description = "", example = "34")
		private Integer version;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;



}
