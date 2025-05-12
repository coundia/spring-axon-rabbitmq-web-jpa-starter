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

		@Schema(description = "", example = "743ac602-9879-48a6-b54c-775dadce23f4")
		private String name;
		@Schema(description = "", example = "18130312-4987-49f8-9821-d23861437996")
		private String value;
		@Schema(description = "", example = "f6cc4122-bd04-4bfd-b26c-eddfbd9f22da")
		private String locale;
		@Schema(description = "", example = "51006575-e228-48a6-bc7e-3f024c7a6162")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "645bdaaa-114f-4ac1-b17f-c9fda19839d3")
		private String reference;

}
