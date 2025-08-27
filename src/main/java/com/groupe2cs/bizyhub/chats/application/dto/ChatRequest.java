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

	@Schema(description = "", example = "c5ce2cec-5e4f-4eb9-a10c-0189d1ad4372")
	private String messages;
	@Schema(description = "", example = "66fd0aa2-6bab-4d53-865c-ead6f75789b9")
	private String responsesJson;
	@Schema(description = "", example = "62ef8c21-24b9-4cf2-91dc-147ea34be714")
	private String responses;
	@Schema(description = "", example = "520770c8-39a5-450a-9154-a5929f574b62")
	private String state;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "83c072e7-8db6-4383-8f23-4228ad32e5a6")
	private String remoteId;
	@Schema(description = "", example = "7e1b7155-a823-4c97-ae7d-62b55db1e0f4")
	private String localId;
	@Schema(description = "", example = "6c16bb45-fcc2-4cfb-a19f-8691db21eddb")
	private String account;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;

}
