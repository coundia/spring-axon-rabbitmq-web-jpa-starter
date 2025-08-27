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

		@Schema(description = "", example = "2ad82320-413c-4868-81e5-5cf4325d9719")
		private String code;
		@Schema(description = "", example = "3fdb3b78-e34e-4e1c-b4aa-a0cba69d5106")
		private String name;
		@Schema(description = "", example = "2d67d945-7c75-4d9f-8880-d8838706317c")
		private String remoteId;
		@Schema(description = "", example = "278c0059-6c66-426e-ab17-f9e288aeeb25")
		private String localId;
		@Schema(description = "", example = "8db9b374-311d-443f-a114-0096b15c3114")
		private String description;
		@Schema(description = "", example = "adbbc5c7-7412-4085-8d1b-09fb26bd1706")
		private String typeEntry;
		@Schema(description = "", example = "66")
		private Integer version;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;

}
