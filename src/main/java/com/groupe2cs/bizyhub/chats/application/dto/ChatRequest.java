package com.groupe2cs.bizyhub.chats.application.dto;

import com.groupe2cs.bizyhub.chats.domain.valueObject.*;
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
@Schema(name = "ChatRequest", description = "Request payload for Chat operations")
public class ChatRequest implements Serializable {

	@Schema(description = "", example = "c0d2a4b3-7a0d-49bc-9550-d8fd66840baa")
	private String messages;

	@Schema(description = "", example = "7801b2b7-0114-4bb7-bdc4-ed2e3e31ad38")
	private String responsesJson;

	@Schema(description = "", example = "3831c813-5ef4-4120-b54a-10391ba766bb")
	private String responses;

	@Schema(description = "", example = "9ab302a3-d8a9-43ab-b4ab-4c1b1958f0c9")
	private String state;

	@Schema(description = "", example = "a52d90a9-0719-41ec-9de1-52c8a5745524")
	private String account;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "6552e3c1-8970-4432-a5b9-72dbe1bfe80f")
	private String reference;


}
