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

	@Schema(description = "", example = "2b9f6fee-8aa6-48e5-8564-f956edbfe315")
	private String name;

	@Schema(description = "", example = "ff223521-104f-4381-8876-9a32d83ef48f")
	private String reference;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "644ccece-8285-41b8-942c-150806f029a3")
	private String stringValue;

	@Schema(description = "", example = "6808888c-2ce7-40b9-8f20-f0d6c36832c2")
	private String descriptions;

	@Schema(description = "", example = "true")
	private Boolean isActive;


}
