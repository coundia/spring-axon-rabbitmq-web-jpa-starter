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

		@Schema(description = "", example = "42bebbd9-c7da-495a-bd65-0f6ee14ee09b")
		private String messages;
		@Schema(description = "", example = "69a80bab-410c-4abb-b485-6a531e6af0f0")
		private String responsesJson;
		@Schema(description = "", example = "8f4cd448-63d2-4a4e-8a53-df233ed9dbc4")
		private String responses;
		@Schema(description = "", example = "b1a18336-f3c7-4e66-ac41-2f39deaa9bae")
		private String state;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "1768ba9d-6513-4cf3-b603-bc575539a612")
		private String remoteId;
		@Schema(description = "", example = "64501ae9-dc7a-435a-8f9d-7dc2ea86c910")
		private String account;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;

}
