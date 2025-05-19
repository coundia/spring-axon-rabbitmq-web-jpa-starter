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

	@Schema(description = "", example = "e801a4bb-f956-48af-9cb4-925d704dd578")
	private String messages;

	@Schema(description = "", example = "daf28391-46bd-4a59-94ba-591378336a6f")
	private String responsesJson;

	@Schema(description = "", example = "f643afbf-6413-4a5e-b311-e00f12933bf1")
	private String responses;

	@Schema(description = "", example = "da52378e-7198-4397-bd49-7d4721c3b825")
	private String state;

	@Schema(description = "", example = "d214a9d0-d77e-49e7-9030-4a45167673bb")
	private String account;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "deddb021-b3ee-4132-9655-dc28bcf933be")
	private String reference;


}
