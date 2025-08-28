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

		@Schema(description = "", example = "31da11c5-11bc-442a-8324-93046fe16f04")
		private String name;
		@Schema(description = "", example = "76621a0b-f71f-4732-811b-20ef4c33eff0")
		private String value;
		@Schema(description = "", example = "8ad31520-caa5-461a-8a5a-ad3f0cf410c7")
		private String locale;
		@Schema(description = "", example = "29c91cf0-9725-4744-b71b-cae9566a22f7")
		private String remoteId;
		@Schema(description = "", example = "bff3e327-354e-4836-a997-a9b6a31a0a17")
		private String localId;
		@Schema(description = "", example = "555a192d-f84a-4f23-8b8f-1f2ff7efd90c")
		private String account;
		@Schema(description = "", example = "0e84fa89-866e-44aa-9be7-eb11523e4a68")
		private String details;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "true")
		private Boolean isActive;

}
