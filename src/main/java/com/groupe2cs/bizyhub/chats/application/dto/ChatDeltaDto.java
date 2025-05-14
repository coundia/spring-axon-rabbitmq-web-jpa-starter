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

		@Schema(description = "", example = "efc1201f-77e5-419c-ace2-2cc6f102bd74")
		private String messages;
		@Schema(description = "", example = "92960a98-0ec5-4fb1-9077-45f5133c7b89")
		private String responses;
		@Schema(description = "", example = "8a226e68-0f42-4e68-965c-f5c6196987e4")
		private String state;
		@Schema(description = "", example = "e3dfc7b6-9e06-46c0-8a09-6f047f9768db")
		private String account;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "3a9824b3-f7e2-4b6b-b9fe-e8f15fb3a4ae")
		private String reference;

}
