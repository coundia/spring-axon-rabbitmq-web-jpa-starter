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

		@Schema(description = "", example = "8037d4bb-28b4-4361-bfc0-fe730c8b5beb")
		private String name;
		@Schema(description = "", example = "65119cd0-b3d8-4fb0-b921-a712fbeda859")
		private String value;
		@Schema(description = "", example = "a28b312d-2fb0-405f-b43e-bf59431b71d1")
		private String locale;
		@Schema(description = "", example = "524b6d79-f291-4ecd-bb18-4cd505a58181")
		private String remoteId;
		@Schema(description = "", example = "ec52b540-3c5e-4e8a-be39-35c4178aec7d")
		private String localId;
		@Schema(description = "", example = "2626ed28-8843-4cbf-b75c-d1e734810834")
		private String details;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "false")
		private Boolean isActive;

}
