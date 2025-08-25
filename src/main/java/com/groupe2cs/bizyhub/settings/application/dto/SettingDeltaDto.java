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

		@Schema(description = "", example = "f488434e-113d-40a8-9e31-e676a6837734")
		private String name;
		@Schema(description = "", example = "650f0dc3-fc63-42d6-8397-435127abbeac")
		private String value;
		@Schema(description = "", example = "1a2721e0-e971-4af9-80f3-ca166d131d0d")
		private String locale;
		@Schema(description = "", example = "93af327c-b52e-4264-ad60-b496bd5d5676")
		private String remoteId;
		@Schema(description = "", example = "def31ccf-20f5-49a6-af90-d2ce53f88cee")
		private String localId;
		@Schema(description = "", example = "f2acd514-9f0d-4071-b209-1f54e8c318c5")
		private String details;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "false")
		private Boolean isActive;

}
