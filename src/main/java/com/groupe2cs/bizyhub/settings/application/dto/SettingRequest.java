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

	@Schema(description = "", example = "94305267-d031-4d53-bfbd-0eb6d434781f")
	private String name;

	@Schema(description = "", example = "f96f87ac-b75d-451e-bb13-1496f2007c89")
	private String value;

	@Schema(description = "", example = "2d109b27-c892-4b30-9e4a-853af4b52144")
	private String locale;

	@Schema(description = "", example = "99e481b9-1fe5-45bc-9c05-8bd57906dd4a")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "ef91ff97-5b5e-41ec-a7d9-63b14b728b71")
	private String reference;


}
