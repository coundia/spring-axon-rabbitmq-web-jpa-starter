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

	@Schema(description = "", example = "e6bd2a45-65ab-4019-83a4-105fed48272c")
	private String name;

	@Schema(description = "", example = "6e9e0eee-131e-4126-8481-b6c6200586ee")
	private String stringValue;

	@Schema(description = "", example = "3205730c-6533-4bdf-8ea1-cafa18111bc5")
	private String description;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "bb6d0b29-0a7d-49d1-b01f-669ab5170b97")
	private String reference;


}
