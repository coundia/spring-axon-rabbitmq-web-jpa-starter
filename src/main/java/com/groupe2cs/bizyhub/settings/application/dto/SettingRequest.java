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

	@Schema(description = "", example = "cc7be9e2-9c0b-4ebc-b6fb-22d0c3e0de6b")
	private String name;
	@Schema(description = "", example = "6ed6fa3e-5f15-4709-805a-d51b14ab7261")
	private String value;
	@Schema(description = "", example = "7180b1ef-b7a9-4f8d-a51f-9cb5cfb77d5f")
	private String locale;
	@Schema(description = "", example = "247bb51e-ea87-438a-a443-91b5d6876bbd")
	private String details;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
