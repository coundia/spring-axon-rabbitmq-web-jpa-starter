package com.groupe2cs.bizyhub.settings.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "SettingRequest", description = "Request payload for Setting operations")
public class SettingRequest implements Serializable {

	@Schema(description = "", example = "deb005fc-8f1d-4d63-939e-f58b29eba36b")
	private String name;

	@Schema(description = "", example = "91cd8fcb-d640-43a4-9b26-bf77072a6f26")
	private String value;

	@Schema(description = "", example = "84c316d9-4713-46ce-89e7-164395d196e2")
	private String locale;

	@Schema(description = "", example = "5a1e17b6-2114-4581-8155-5aeb30185d35")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "7d97f58a-b6e9-4329-b607-1b79e7ab1372")
	private String reference;


}
