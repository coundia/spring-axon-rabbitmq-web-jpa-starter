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

		@Schema(description = "", example = "001afe2b-35c9-4274-b709-04c10553927f")
		private String name;
		@Schema(description = "", example = "5c726b23-2f7e-46c6-82b8-ee1e50a61d77")
		private String value;
		@Schema(description = "", example = "c67a2d4c-6820-4c22-95ce-f663827a8f55")
		private String locale;
		@Schema(description = "", example = "9f77b73a-89dc-4bc7-9dd9-44279108024d")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "5a867d96-177c-419f-a509-d44f5ffface9")
		private String reference;

}
