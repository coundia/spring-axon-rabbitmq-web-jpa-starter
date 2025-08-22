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

		@Schema(description = "", example = "c8b7e68d-90d2-4ced-bf2c-1b5f826a736c")
		private String name;
		@Schema(description = "", example = "4059661e-4866-417f-af10-205928e2036f")
		private String value;
		@Schema(description = "", example = "3f1f0c3d-b716-45a5-95e6-a32f04b0721b")
		private String locale;
		@Schema(description = "", example = "d971b831-d66b-46f2-93af-80ce5c6f7239")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;

}
