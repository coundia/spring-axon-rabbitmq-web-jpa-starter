package com.groupe2cs.bizyhub.message.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "MessageRequest", description = "Request payload for Message operations")
public class MessageRequest implements Serializable {

	@Schema(description = "", example = "75eb9bad-2778-4f4c-82e2-e41d1b5a50a6")
	private String code;
	@Schema(description = "", example = "a1c6b783-83ef-4f88-ae08-a36636efccd8")
	private String email;
	@Schema(description = "", example = "77f0e916-43a9-4a63-bc37-a4fbb8f015dd")
	private String phone;
	@Schema(description = "", example = "2efe978a-83c8-4017-99ed-204f85ada2e9")
	private String content;
	@Schema(description = "", example = "a0ef1fa6-4506-41f5-9c56-a083558ac179")
	private String plateforme;
	@Schema(description = "", example = "6a9ed388-bbf0-4ba7-aa4a-39cac49671bd")
	private String source;
	@Schema(description = "", example = "48e81ef0-8213-468b-8ae7-5c8355a3f73d")
	private String agent;
	@Schema(description = "", example = "bf62a451-381c-4de0-899c-243c2be9042b")
	private String status;
	@Schema(description = "", example = "9bdc23dc-dd6e-4d07-aeda-fb2e362c5c3e")
	private String description;
	@Schema(description = "", example = "true")
	private Boolean isActive;
	@Schema(description = "", example = "true")
	private Boolean isDefault;
	@Schema(description = "", example = "b6746712-e1cb-47ff-8e53-9c2a2a58f38e")
	private String remoteId;
	@Schema(description = "", example = "9ba7b93c-d545-42ce-914f-7f1444e693e0")
	private String localId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant depotAt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;

}
