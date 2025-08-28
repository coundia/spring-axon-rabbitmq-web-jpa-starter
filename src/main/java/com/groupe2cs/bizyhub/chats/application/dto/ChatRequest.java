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

	@Schema(description = "", example = "53929db2-8a89-42ba-8cb5-b57d73337f08")
	private String messages;
	@Schema(description = "", example = "11e49a25-a9bd-4c59-8075-c9113eda05ca")
	private String responsesJson;
	@Schema(description = "", example = "d664386f-8bcb-4424-813f-2f8e26775cc3")
	private String responses;
	@Schema(description = "", example = "bcef136c-525d-49c2-9dfe-1f40366f0919")
	private String state;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "754c8060-8c40-42df-adf7-d80acd7f2563")
	private String remoteId;
	@Schema(description = "", example = "e90e038b-06cc-47be-af43-0555fcbc212d")
	private String localId;
	@Schema(description = "", example = "377b2ef4-9c42-45e5-8551-4a16aa78ce78")
	private String account;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;

}
