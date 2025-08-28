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

		@Schema(description = "", example = "fa622ccf-78ad-475a-ad64-c9bbc6ceb065")
		private String messages;
		@Schema(description = "", example = "a0cbfea2-bf70-43f8-bd45-0bf1129e871c")
		private String responsesJson;
		@Schema(description = "", example = "f0aa4783-6bee-41e0-954c-1006c45c9e0d")
		private String responses;
		@Schema(description = "", example = "d077f6a0-83b9-4458-b9b2-b432e9a3c39d")
		private String state;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "c9f00c64-dfbc-420b-9532-48574fbc0764")
		private String remoteId;
		@Schema(description = "", example = "c91ca322-3035-4e48-a7e0-7e4a5c80e8ec")
		private String localId;
		@Schema(description = "", example = "16042227-cef8-4400-ac3d-7f91d58b4375")
		private String account;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;

}
