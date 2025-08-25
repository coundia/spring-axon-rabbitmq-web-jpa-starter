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

		@Schema(description = "", example = "4fe441fc-8324-4a0b-bb3c-767c66c2464a")
		private String messages;
		@Schema(description = "", example = "9cfe90da-f589-4976-8fb8-5c5667e51575")
		private String responsesJson;
		@Schema(description = "", example = "58445697-148d-4e60-9063-7a3ee05a906a")
		private String responses;
		@Schema(description = "", example = "9bd4fce2-4a19-4546-ab41-9b3ee4701ca4")
		private String state;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "66ea306d-9f53-4031-abb9-4d54a1b38719")
		private String remoteId;
		@Schema(description = "", example = "887f54f7-3e99-466f-950c-43fcb7daeb22")
		private String localId;
		@Schema(description = "", example = "97034983-0777-4183-83d6-02452b1d6954")
		private String account;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;

}
