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

	@Schema(description = "", example = "d59d2037-eb30-4a8c-975e-400ef65f0377")
	private String name;

	@Schema(description = "", example = "111b100f-5da0-433e-bb61-6926cf6c9aa7")
	private String value;

	@Schema(description = "", example = "ed7c00e8-b54e-4c49-9687-466e157694ff")
	private String locale;

	@Schema(description = "", example = "68bf299e-e7da-4847-a351-92b0005ee133")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "54a9ae78-301c-402c-9052-fe2f17d26282")
	private String reference;


}
