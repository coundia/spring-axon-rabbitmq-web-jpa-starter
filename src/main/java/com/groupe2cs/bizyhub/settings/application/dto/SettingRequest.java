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

	@Schema(description = "", example = "aadcbca7-30d3-46d2-9a99-27634c751d20")
	private String name;

	@Schema(description = "", example = "82d8b9c1-ee13-41d6-8eac-fc8cc129d45c")
	private String value;

	@Schema(description = "", example = "22eaa83a-4950-47f0-9561-5511d2e7ab3c")
	private String locale;

	@Schema(description = "", example = "7b704772-d27a-431a-846d-d8618be40bc3")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "8a2d0c2d-ec52-4318-85ce-d3949c937b0b")
	private String reference;


}
