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

		@Schema(description = "", example = "bc5418a0-6aec-433d-9385-728be8973966")
		private String messages;
		@Schema(description = "", example = "0c81d1b0-6193-4c23-ba9c-dac1c12bef2b")
		private String responsesJson;
		@Schema(description = "", example = "4b0e5772-6608-4cb6-9613-7018fc07ad14")
		private String responses;
		@Schema(description = "", example = "f4ab9a34-7608-4167-b613-15eb5bebad02")
		private String state;
		@Schema(description = "", example = "cf20b6c8-aae7-460a-bdda-1cf1d9cbd0be")
		private String account;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "904e09b0-5c6f-484d-b03f-eac4d60b21c4")
		private String reference;

}
