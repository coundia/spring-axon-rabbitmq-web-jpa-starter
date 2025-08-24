package com.groupe2cs.bizyhub.settings.application.dto;

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
@Schema(name = "SettingDeltaDto", description = "Delta DTO for setting changes")
public class SettingDeltaDto implements Serializable {

    @Schema(description = "Identifier of the setting", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "e44d1802-4c7f-4d49-8c58-588cc7975948")
		private String name;
		@Schema(description = "", example = "e2c68253-0f01-42a2-8da4-aa88327ecaae")
		private String value;
		@Schema(description = "", example = "5d2efc03-0228-45c1-83aa-11915bda8289")
		private String locale;
		@Schema(description = "", example = "c4a63d82-9326-41d1-93ae-a55ebe57b240")
		private String remoteId;
		@Schema(description = "", example = "aa9bdb66-d3a3-4fb7-98f7-f7699170ef66")
		private String localId;
		@Schema(description = "", example = "56ea635d-f47f-41bb-a3d0-3bfda81fe76f")
		private String details;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "false")
		private Boolean isActive;

}
