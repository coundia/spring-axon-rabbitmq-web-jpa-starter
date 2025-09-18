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

		@Schema(description = "", example = "a03cfc72-fc5c-49d8-8838-5a0fe4ad1d8c")
		private String code;
		@Schema(description = "", example = "5a66e3e4-5566-4456-a8ea-9257368436fc")
		private String name;
		@Schema(description = "", example = "c343c783-4651-470e-a508-de3bb4e3e23c")
		private String remoteId;
		@Schema(description = "", example = "aeb1d5ef-f681-4564-bdb4-df22a0fb9999")
		private String localId;
		@Schema(description = "", example = "4d450b6a-5817-42a5-9c26-fbe4ef201a2b")
		private String account;
		@Schema(description = "", example = "74fb614a-9eca-4012-8559-69d7e3a0eb62")
		private String status;
		@Schema(description = "", example = "false")
		private Boolean isPublic;
		@Schema(description = "", example = "f33e59ce-b700-4406-a658-d0bf27267ac7")
		private String description;
		@Schema(description = "", example = "4940814b-b88f-4fc7-9d8b-f66e4072b7ce")
		private String typeEntry;
		@Schema(description = "", example = "70")
		private Integer version;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;

}
