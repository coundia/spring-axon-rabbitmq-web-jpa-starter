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

	@Schema(description = "", example = "168b725a-9e1c-4361-9a53-cd7c8f3befd5")
	private String messages;
	@Schema(description = "", example = "ee859076-857a-4180-b603-35b0687871b4")
	private String responsesJson;
	@Schema(description = "", example = "e7e0e70e-2ebd-4bee-8bec-9003bff2ce73")
	private String responses;
	@Schema(description = "", example = "2bffeb2a-6d4d-4f98-b6b7-ba01420c12c2")
	private String state;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "22341dc6-b248-40b9-aae9-7f1a30f907de")
	private String account;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;

}
