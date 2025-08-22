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

		@Schema(description = "", example = "b3e58360-4f7a-4159-94aa-228cc2a4686e")
		private String messages;
		@Schema(description = "", example = "af4e54e0-e44b-419a-9b75-984e805172d8")
		private String responsesJson;
		@Schema(description = "", example = "5d6f74ed-c3a2-4cde-8270-a89e33cd132c")
		private String responses;
		@Schema(description = "", example = "30c9e17e-1bd0-4a16-8774-e8aa6cb38180")
		private String state;
		@Schema(description = "", example = "a9cb0331-809e-4891-9b9a-7adfdbe6628c")
		private String account;

}
