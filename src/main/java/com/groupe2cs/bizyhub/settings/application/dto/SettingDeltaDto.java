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

		@Schema(description = "", example = "4f521764-f330-4cde-91ea-e5ca0084832b")
		private String name;
		@Schema(description = "", example = "231c5215-c83c-4ba7-91d8-d3f44c468871")
		private String value;
		@Schema(description = "", example = "716f82e9-4346-47cf-9b73-01cfa060940a")
		private String locale;
		@Schema(description = "", example = "965b7007-048f-45b7-a911-a5c59290c3bf")
		private String remoteId;
		@Schema(description = "", example = "6e442edb-7b53-4610-b533-1e5eee90da3e")
		private String details;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "false")
		private Boolean isActive;

}
