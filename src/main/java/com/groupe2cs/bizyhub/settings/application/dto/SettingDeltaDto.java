package com.groupe2cs.bizyhub.settings.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

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

	@Schema(description = "", example = "a9747574-eabe-4b9c-9ff8-abe79452a799")
	private String name;
	@Schema(description = "", example = "f0d9abe8-20d8-4d7e-beb5-83a0425adc09")
	private String stringValue;
	@Schema(description = "", example = "7566c49c-f3f0-4dad-9e9d-f78ec8243417")
	private String description;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
