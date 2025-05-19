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

		@Schema(description = "", example = "ac317eb9-c152-45a8-98b2-9278feaf5238")
		private String messages;
		@Schema(description = "", example = "d1024406-43ed-4388-896e-5d7a6ece2be1")
		private String responsesJson;
		@Schema(description = "", example = "64adf040-986e-4f91-b89d-501dbe229579")
		private String responses;
		@Schema(description = "", example = "d0db65c7-5445-46f4-8eb6-0041d97ab55b")
		private String state;
		@Schema(description = "", example = "e6b4f6f9-9574-4864-87cc-88bc1a084193")
		private String account;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "c958820b-d5b4-41e0-b862-6885e05c1359")
		private String reference;

}
