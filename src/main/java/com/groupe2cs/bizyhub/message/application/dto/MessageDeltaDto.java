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

		@Schema(description = "", example = "75349af4-c2fe-45c8-90a6-3cb47741bf3e")
		private String code;
		@Schema(description = "", example = "5c39cc84-0b51-4f24-864e-5d2d38c4c93b")
		private String email;
		@Schema(description = "", example = "644cb894-9cee-4425-bd3e-19df9bdab4f5")
		private String phone;
		@Schema(description = "", example = "f11490bc-9595-4abe-ba6a-2bf5ded54b3b")
		private String content;
		@Schema(description = "", example = "618fc804-a2d4-46bf-a55f-b6d241f4af7a")
		private String plateforme;
		@Schema(description = "", example = "c029fcc8-5b6d-4663-91af-7341bc3caf4c")
		private String source;
		@Schema(description = "", example = "86311a30-dfc6-430d-80c9-df4e195580f3")
		private String agent;
		@Schema(description = "", example = "690062ce-68c1-4e06-8a01-c536a02a3b2b")
		private String status;
		@Schema(description = "", example = "1ad31860-1180-4515-82f8-55502295a3e1")
		private String description;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "true")
		private Boolean isDefault;
		@Schema(description = "", example = "509f5294-c8e2-4b10-bcf8-3a993234fe3f")
		private String remoteId;
		@Schema(description = "", example = "fc6bdd5c-f341-4ba5-bc21-907c2d866eb3")
		private String localId;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant depotAt;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;

}
