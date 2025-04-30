package com.groupe2cs.bizyhub.settings.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "SettingRequest", description = "Request payload for Setting operations")
public class SettingRequest implements Serializable {

	@Schema(description = "", example = "bca7b20b-9a33-4732-994d-5d20a644ab2a")
	private String name;

	@Schema(description = "", example = "06918e35-2274-4279-99ed-6598dab157d8")
	private String stringValue;

	@Schema(description = "", example = "f0de58be-c607-4ab5-a30b-4a208528327e")
	private String description;

	@Schema(description = "", example = "false")
	private Boolean isActive;


}
