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

	@Schema(description = "", example = "10688b9c-1b85-4f46-bd47-b4bcc959084b")
	private String messages;
	@Schema(description = "", example = "b0ed9865-6706-481d-8fde-ed1121b8b952")
	private String responsesJson;
	@Schema(description = "", example = "c378b3bd-9c9d-4900-83ba-069c55b03eec")
	private String responses;
	@Schema(description = "", example = "3bbecdb2-8f3a-45f1-924e-309dacbbae5d")
	private String state;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "d29003c2-607f-4eb3-ab00-2a9b8eb57eea")
	private String remoteId;
	@Schema(description = "", example = "90f62697-aa8e-4f4d-8bda-758003a55b3a")
	private String account;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;

}
