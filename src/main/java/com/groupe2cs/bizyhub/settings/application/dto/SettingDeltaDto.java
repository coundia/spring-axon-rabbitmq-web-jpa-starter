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

		@Schema(description = "", example = "9f367e91-f75e-4042-b778-4a04f136767d")
		private String name;
		@Schema(description = "", example = "96db6e85-4316-410e-8419-c4462dc0eb61")
		private String value;
		@Schema(description = "", example = "9d9bc4d0-2d52-473e-9293-fb9aed99b59c")
		private String locale;
		@Schema(description = "", example = "b6d382c2-f79e-438d-bfda-27ad1768d639")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "086caf51-2972-47b8-85ca-0977f06e815e")
		private String reference;

}
