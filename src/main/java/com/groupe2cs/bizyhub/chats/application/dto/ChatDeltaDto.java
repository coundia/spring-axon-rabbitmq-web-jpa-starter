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

		@Schema(description = "", example = "f5fd7c47-6f10-4fd1-bd96-1886b2802df0")
		private String messages;
		@Schema(description = "", example = "c94e6ceb-2080-4a38-861f-347cfbf2caef")
		private String responsesJson;
		@Schema(description = "", example = "258d64e4-82cc-4269-a051-e1a57983b841")
		private String responses;
		@Schema(description = "", example = "e4c9219f-dc97-4128-b4d0-19b301bd3597")
		private String state;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "61de86f8-d52b-48c7-b5d2-0dae8cdddd1d")
		private String remoteId;
		@Schema(description = "", example = "ae6e9882-a02d-430b-ad85-8e3874d0389a")
		private String localId;
		@Schema(description = "", example = "b32731d4-618a-4ff3-9acf-b9bb6b9feb40")
		private String account;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;

}
