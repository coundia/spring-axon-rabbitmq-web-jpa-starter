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

	@Schema(description = "", example = "b3c1f67a-b5ea-459c-bae6-3fee6227c042")
	private String messages;

	@Schema(description = "", example = "3ea7ee69-2242-49e4-b845-bbee07e2f3ed")
	private String responsesJson;

	@Schema(description = "", example = "6572457b-359b-47ed-ae9d-eabec419a648")
	private String responses;

	@Schema(description = "", example = "ce4a819d-f125-4432-be50-b5a709cc1f00")
	private String state;

	@Schema(description = "", example = "c147f2b7-5695-49c9-a01e-66eb09776351")
	private String account;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "01e1f0e4-9ec8-4835-8509-75d58e44a0e7")
	private String reference;


}
