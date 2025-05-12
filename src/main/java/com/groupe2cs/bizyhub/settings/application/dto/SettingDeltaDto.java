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

		@Schema(description = "", example = "96093abc-5123-4f40-9986-57d1eaea7987")
		private String name;
		@Schema(description = "", example = "bb533a3b-6884-41db-958f-dbedf85abeb7")
		private String value;
		@Schema(description = "", example = "08d79411-1ebc-441b-8644-581ea78dc748")
		private String locale;
		@Schema(description = "", example = "0ca0a3be-a370-47f0-9c08-6f737a8345d3")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "a25bd0e1-7573-4a28-b8c3-5f5095983c45")
		private String reference;

}
