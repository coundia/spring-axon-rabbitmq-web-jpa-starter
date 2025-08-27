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

		@Schema(description = "", example = "8c62f857-b5e7-47c9-a517-6735b129838f")
		private String messages;
		@Schema(description = "", example = "83517d9a-5f4d-4e39-942f-8d34a16389f0")
		private String responsesJson;
		@Schema(description = "", example = "20648463-af5b-4892-aecd-c8cc06ed49e5")
		private String responses;
		@Schema(description = "", example = "e65fa709-7074-4bae-9cba-f22357ad1fe9")
		private String state;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "8eb105e1-eaea-4c33-87e1-905339052c85")
		private String remoteId;
		@Schema(description = "", example = "5208d2d4-1b3b-42c4-b665-d5ec9d31612d")
		private String localId;
		@Schema(description = "", example = "ad929808-0b8d-486b-bcbf-3c0430752742")
		private String account;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;

}
