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

	@Schema(description = "", example = "7f2bf81d-6400-4623-9a30-34b1f4838d17")
	private String name;

	@Schema(description = "", example = "23507bca-abb7-4c26-ad50-1b96a5e1ef4f")
	private String value;

	@Schema(description = "", example = "0094e854-b48d-4bf3-ab6f-32c76b97dc6e")
	private String locale;

	@Schema(description = "", example = "6f66bbbf-495d-4b76-99b1-62bec9034df8")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "bb251220-f131-479c-9aa5-9516edae3678")
	private String reference;


}
