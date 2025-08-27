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

	@Schema(description = "", example = "c7a06052-3c75-4e58-a2bb-da48cce0437f")
	private String name;
	@Schema(description = "", example = "81f92146-749f-443d-815a-01f670bc125a")
	private String value;
	@Schema(description = "", example = "6dcef9cc-7585-4505-9ab7-d13b0eaf5f20")
	private String locale;
	@Schema(description = "", example = "fba4db52-9328-4c0f-aca9-37dcad031ec5")
	private String remoteId;
	@Schema(description = "", example = "d320d470-af2a-4b1a-b3cd-875fab983423")
	private String localId;
	@Schema(description = "", example = "bead969f-6d10-4e68-9888-fc1c5c0342f5")
	private String details;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "true")
	private Boolean isActive;

}
