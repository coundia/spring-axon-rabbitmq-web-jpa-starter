package com.groupe2cs.bizyhub.chats.application.dto;

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
@Schema(name = "ChatDeltaDto", description = "Delta DTO for chat changes")
public class ChatDeltaDto implements Serializable {

    @Schema(description = "Identifier of the chat", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "32d2adbe-7eb1-4804-9a7e-fa3e3611ca39")
		private String messages;
		@Schema(description = "", example = "7a44b380-a33a-47b2-b89a-974582877763")
		private String responsesJson;
		@Schema(description = "", example = "f0d49388-6817-4554-9f12-561214e2efa0")
		private String responses;
		@Schema(description = "", example = "0f365661-9982-4dd9-bbb5-af43a245f83a")
		private String state;
		@Schema(description = "", example = "f43b4609-8763-4187-a492-0462420140b2")
		private String account;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "67c68c39-90b9-4f7c-8787-5cebd382e848")
		private String reference;

}
