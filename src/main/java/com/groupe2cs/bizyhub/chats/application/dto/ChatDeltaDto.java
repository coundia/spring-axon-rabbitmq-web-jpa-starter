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

		@Schema(description = "", example = "ff65be21-adf8-45c4-b79b-a94e177150c5")
		private String messages;
		@Schema(description = "", example = "4bfb6414-991a-4ecf-8157-35849d289b27")
		private String responses;
		@Schema(description = "", example = "3f6f4eb3-ff31-48e9-b316-13be4fe3a8e5")
		private String state;
		@Schema(description = "", example = "43fc4315-9f97-4680-8a7b-a62c44768388")
		private String account;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "1b7bc68b-a197-4139-86d3-58f02c5cbf24")
		private String reference;

}
