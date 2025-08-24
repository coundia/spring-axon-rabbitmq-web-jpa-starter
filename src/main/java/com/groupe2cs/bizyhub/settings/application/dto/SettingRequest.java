package com.groupe2cs.bizyhub.settings.application.dto;

import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
import java.util.UUID;
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
@Schema(name = "SettingRequest", description = "Request payload for Setting operations")
public class SettingRequest implements Serializable {

	@Schema(description = "", example = "1ae11211-da7b-4221-bf69-9621e9a6e499")
	private String name;
	@Schema(description = "", example = "b38adc0a-8924-44c8-a429-1455ed91ded4")
	private String value;
	@Schema(description = "", example = "c861948f-88fb-4b8c-bf58-45d620d10144")
	private String locale;
	@Schema(description = "", example = "e9aab4c6-9a90-44b9-b55e-0217c0e724b0")
	private String remoteId;
	@Schema(description = "", example = "50d3d8af-4c3b-4c92-947c-176c1a5fc370")
	private String details;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
