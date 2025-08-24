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

	@Schema(description = "", example = "57a1e927-36d7-44c6-8173-528fb0c50f7b")
	private String name;
	@Schema(description = "", example = "ac7e20a1-73e0-46c7-a6b5-0fb4182dfbc8")
	private String value;
	@Schema(description = "", example = "c52a995c-e4d6-4120-b7a1-630924af3a5f")
	private String locale;
	@Schema(description = "", example = "a538f1e1-55f1-4cb1-9b9a-059efe4d2cfe")
	private String remoteId;
	@Schema(description = "", example = "754d003b-0622-4bf6-bc1b-9c67b9788b65")
	private String localId;
	@Schema(description = "", example = "545ed192-d3d4-4ff3-9164-8fb96916b857")
	private String details;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
