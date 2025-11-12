package com.groupe2cs.bizyhub.message.application.dto;

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
@Schema(name = "MessageDeltaDto", description = "Delta DTO for message changes")
public class MessageDeltaDto implements Serializable {

    @Schema(description = "Identifier of the message", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "61fbd71e-fd5f-42a3-9128-9f0fb119ab03")
		private String code;
		@Schema(description = "", example = "22b1181e-ad43-43b2-b23a-d794dc6d5f81")
		private String email;
		@Schema(description = "", example = "0bb18e82-7e2a-4bdb-82ea-600ef13be32e")
		private String phone;
		@Schema(description = "", example = "34c491c8-fabc-4dce-9f6b-d6a1cbc04ff5")
		private String content;
		@Schema(description = "", example = "af20bbde-3d29-42b7-aa42-f7d506592117")
		private String plateforme;
		@Schema(description = "", example = "dcb9da64-83e4-47c1-a721-7f8a5b342187")
		private String source;
		@Schema(description = "", example = "dbd3830d-b34d-44ba-a336-f0b028b4ae0b")
		private String agent;
		@Schema(description = "", example = "f79025f9-48da-4a6d-bf98-88c088a6c664")
		private String status;
		@Schema(description = "", example = "9a5bcd68-a673-4c1e-9123-f86b8ed18f11")
		private String description;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "true")
		private Boolean isDefault;
		@Schema(description = "", example = "644d96ed-538a-4230-bb22-2f26a9557ebe")
		private String remoteId;
		@Schema(description = "", example = "65a1dc16-9fb6-443d-abbf-1cbcb9da9d75")
		private String localId;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant depotAt;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;

}
