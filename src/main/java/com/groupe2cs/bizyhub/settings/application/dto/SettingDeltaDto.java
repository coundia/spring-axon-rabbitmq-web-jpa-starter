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

		@Schema(description = "", example = "72ff2f05-4e4d-4a33-935b-db6fb9fb93a7")
		private String name;
		@Schema(description = "", example = "085d3160-9f23-4a0e-a73a-98840248d38e")
		private String value;
		@Schema(description = "", example = "b5ba1484-54ff-457a-81a8-ca5e912bd4d5")
		private String locale;
		@Schema(description = "", example = "943f9463-312c-48bf-b610-8a98a088e1c1")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;

}
