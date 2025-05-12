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

	@Schema(description = "", example = "0b7c5ee6-5f10-4277-84bb-70f1d9ad0baa")
	private String name;

	@Schema(description = "", example = "ecf9a428-d3bd-40eb-87d9-d2d587546783")
	private String value;

	@Schema(description = "", example = "c64bc081-a4a4-4fe2-831f-47a2260f89c8")
	private String locale;

	@Schema(description = "", example = "1d28e450-78d3-4352-8829-c14e46ddb38d")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "b7a8dfdf-6337-44f5-8768-cd2905f7b8e4")
	private String reference;


}
