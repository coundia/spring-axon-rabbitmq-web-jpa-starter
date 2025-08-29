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

	@Schema(description = "", example = "b4223bb0-23ed-46f3-9a01-4b5a12b9548d")
	private String messages;
	@Schema(description = "", example = "a5123d10-2178-44b6-b6c5-b02da4ff5e67")
	private String responsesJson;
	@Schema(description = "", example = "1098d38d-77f4-44cc-97ca-6c9168c9b001")
	private String responses;
	@Schema(description = "", example = "cf387ca5-cdb2-4dad-aaa5-e34a704794d0")
	private String state;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "dced7812-a95a-407d-a322-b4342bad5571")
	private String remoteId;
	@Schema(description = "", example = "9a5fc370-6c41-4343-9f5c-4c1221c96aa0")
	private String localId;
	@Schema(description = "", example = "715cc399-ef74-4a53-a324-d505f57855fb")
	private String account;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;

}
