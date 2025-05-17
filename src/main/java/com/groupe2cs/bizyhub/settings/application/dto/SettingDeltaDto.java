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

		@Schema(description = "", example = "001f911d-4302-4636-9e04-91199e782d0f")
		private String name;
		@Schema(description = "", example = "baf8c6aa-9218-4e95-84ed-fb21bbd23246")
		private String value;
		@Schema(description = "", example = "3502dd4a-b139-4acb-9424-0910d53616da")
		private String locale;
		@Schema(description = "", example = "7b3cb393-3c7b-4bec-82b4-ff20de71786a")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "dfc4e95b-4eec-4c0c-a607-596b44f06343")
		private String reference;

}
