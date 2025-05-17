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

		@Schema(description = "", example = "ae732e7a-acd1-4254-97fe-c2d3029ca232")
		private String messages;
		@Schema(description = "", example = "2ac80eb4-7c6f-45a9-a3df-c9f657f9b8a6")
		private String responsesJson;
		@Schema(description = "", example = "fc5c6d1e-87a3-47cc-bfc4-7c5ff944da42")
		private String responses;
		@Schema(description = "", example = "73b7fb94-b296-489d-9b57-f5e42057aa64")
		private String state;
		@Schema(description = "", example = "9921b942-b94d-49e2-a76f-31c9777b25db")
		private String account;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "cf95bc4a-e2ad-43ef-b2e7-593d1aca74c7")
		private String reference;

}
