package com.groupe2cs.bizyhub.settings.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Schema(name = "SettingDeltaDto", description = "Delta DTO for setting changes")
public class SettingDeltaDto implements Serializable {

	@Schema(description = "Identifier of the setting", example = "uuid")
	private String id;

	@Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
	private String type = "CREATE";

	@Schema(description = "", example = "2f64826f-ace4-49bb-8f9a-6ceaf40f3849")
	private String name;
	@Schema(description = "", example = "12e40a93-ae06-4c24-8f14-5afe42995b73")
	private String value;
	@Schema(description = "", example = "d9ffe54c-c026-4b97-9ade-a3b554e5a191")
	private String locale;
	@Schema(description = "", example = "57d9dc59-4d5c-4b00-900e-f099326ca543")
	private String remoteId;
	@Schema(description = "", example = "61f54853-afde-4e31-ab40-a48a2196d0a9")
	private String localId;
	@Schema(description = "", example = "d143662d-02b6-427c-bc67-10172f5ff6be")
	private String account;
	@Schema(description = "", example = "8ceed3a1-8314-415a-8f81-73d409038be4")
	private String details;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "true")
	private Boolean isActive;

}
