package com.groupe2cs.bizyhub.settings.application.dto;

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
@Schema(name = "SettingDeltaDto", description = "Delta DTO for setting changes")
public class SettingDeltaDto implements Serializable {

    @Schema(description = "Identifier of the setting", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "fbf39cb6-b5e8-44c3-83aa-ba73e47cab26")
		private String name;
		@Schema(description = "", example = "df6b850e-9143-4113-be5f-27a68eec3032")
		private String reference;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "9801c128-4df4-49e7-985b-f59c11d60a7e")
		private String stringValue;
		@Schema(description = "", example = "e68ad798-4297-4211-beb9-25085e53b831")
		private String descriptions;
		@Schema(description = "", example = "true")
		private Boolean isActive;

}
