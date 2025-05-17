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

	@Schema(description = "", example = "43f70f19-5d6d-4534-8c3f-16982ecf1e6e")
	private String name;

	@Schema(description = "", example = "cab1ed0f-b6f5-49ec-9dbd-89198d4f7ea6")
	private String value;

	@Schema(description = "", example = "fdb14c8b-cf0c-45f1-a7ef-510ea8498ccc")
	private String locale;

	@Schema(description = "", example = "2815204d-581f-4ff5-be7f-61411fd0a4e9")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "c34f5bbc-e65e-4f0e-b484-cee7ccc92e19")
	private String reference;


}
