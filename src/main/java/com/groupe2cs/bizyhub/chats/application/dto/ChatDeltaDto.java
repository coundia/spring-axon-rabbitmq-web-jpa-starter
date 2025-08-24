package com.groupe2cs.bizyhub.chats.application.dto;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import lombok.ToString;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Schema(name = "ChatDeltaDto", description = "Delta DTO for chat changes")
public class ChatDeltaDto implements Serializable {

    @Schema(description = "Identifier of the chat", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "cf32d866-35fe-44b6-9a23-0d5f7e45a769")
		private String messages;
		@Schema(description = "", example = "f28bee8f-4386-476c-996a-81011722c963")
		private String responsesJson;
		@Schema(description = "", example = "84c207e2-b381-4b9c-b97c-ac402295f297")
		private String responses;
		@Schema(description = "", example = "8697bebb-44c2-41d8-a92c-18669b850671")
		private String state;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "75a288fb-0241-4a91-b661-b9b13c7ac3f9")
		private String remoteId;
		@Schema(description = "", example = "39b365df-04e8-4f3e-b4e8-68a60948eb4d")
		private String localId;
		@Schema(description = "", example = "0831ee87-0290-4602-bc35-3214939e06e1")
		private String account;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;

}
