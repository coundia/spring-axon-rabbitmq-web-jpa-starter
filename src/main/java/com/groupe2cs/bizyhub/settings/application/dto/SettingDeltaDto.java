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

		@Schema(description = "", example = "0e64e758-d77b-441b-b48c-03e901ab0bd6")
		private String name;
		@Schema(description = "", example = "5ae89a7c-aaa8-4a9c-a3d6-80c62f46ca81")
		private String value;
		@Schema(description = "", example = "24d63380-a1ac-4866-a39e-f2c7c5338342")
		private String locale;
		@Schema(description = "", example = "1df86540-d516-4f03-bc6d-66f6d2aff2e4")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "62160943-0f8f-4207-ac7c-2b11ec09890e")
		private String reference;

}
