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

	@Schema(description = "", example = "c9242120-4fb3-4d71-86a0-4d0273be07fb")
	private String messages;

	@Schema(description = "", example = "4bd4a74c-93d6-4a4a-a47f-248b69a0bbd6")
	private String responsesJson;

	@Schema(description = "", example = "20b186d7-9fa4-49ae-ac86-3bf4851b2fcb")
	private String responses;

	@Schema(description = "", example = "fe9b6345-900f-4e02-9247-e12fc9590655")
	private String state;

	@Schema(description = "", example = "8262ba92-7a6f-4f06-98eb-ee2369296343")
	private String account;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "c60819cd-2e10-4ce6-a8e4-c12b1c5f153d")
	private String reference;


}
