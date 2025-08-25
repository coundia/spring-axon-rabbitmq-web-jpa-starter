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

	@Schema(description = "", example = "236751a8-2973-4d9e-a5e8-acf9c25e8d8e")
	private String messages;
	@Schema(description = "", example = "d61bcb66-4e12-438c-a835-28bc96a5cf27")
	private String responsesJson;
	@Schema(description = "", example = "b3b512a6-8077-436a-b302-0fe4c55c3f17")
	private String responses;
	@Schema(description = "", example = "3cb0ef44-92a9-477d-81ea-5d0156092752")
	private String state;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "000ced30-7d76-42cc-89b1-87d05af77720")
	private String remoteId;
	@Schema(description = "", example = "19c7bdec-bfb0-4950-9295-2aa7e1969355")
	private String localId;
	@Schema(description = "", example = "95568d73-c729-4bf5-9e0b-69c1110292c8")
	private String account;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant dateTransaction;

}
