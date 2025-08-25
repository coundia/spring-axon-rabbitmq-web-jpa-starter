package com.groupe2cs.bizyhub.notifications.application.dto;

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
@Schema(name = "NotificationDeltaDto", description = "Delta DTO for notification changes")
public class NotificationDeltaDto implements Serializable {

    @Schema(description = "Identifier of the notification", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "a8eada45-b332-44e8-952b-ba1bc116d733")
		private String deviceToken;
		@Schema(description = "", example = "3346c1a4-77c5-4c1e-be69-ee0b3905b4e8")
		private String title;
		@Schema(description = "", example = "4c7e20cc-5674-4c55-89af-b38d7d681a03")
		private String message;
		@Schema(description = "", example = "78a4e149-6ccc-40a6-ae41-f3023b6eb5f2")
		private String status;
		@Schema(description = "", example = "5cc6cba4-4c34-45ad-a319-29dd909b40c0")
		private String remoteId;
		@Schema(description = "", example = "2de2508f-5a6e-4664-a8fc-38f3ce52ce20")
		private String localId;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "e32c7858-043f-410e-ad88-fe07fb994d83")
		private String reserved;
		@Schema(description = "", example = "10e9a666-f6e4-4e61-a47f-ef1ecddf04d5")
		private String errorMessage;

}
