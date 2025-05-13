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

		@Schema(description = "", example = "b29c4cd0-44d8-46e3-ac75-806c734c38a8")
		private String name;
		@Schema(description = "", example = "5ee7514e-162f-474e-b1aa-31c38fe631de")
		private String value;
		@Schema(description = "", example = "5022b4cc-cc77-4b18-bdb3-9cd9498dfa47")
		private String locale;
		@Schema(description = "", example = "0daf0209-309c-4317-a31e-b5199c84c03b")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "a5dab669-2a2e-46e9-ab39-ecf0c35e4d51")
		private String reference;

}
