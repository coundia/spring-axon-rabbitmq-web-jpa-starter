package com.groupe2cs.bizyhub.notifications.application.dto;

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
@Schema(name = "NotificationDeltaDto", description = "Delta DTO for notification changes")
public class NotificationDeltaDto implements Serializable {

    @Schema(description = "Identifier of the notification", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "a8d45342-47e9-4705-8599-2994dbe18cb2")
		private String deviceToken;
		@Schema(description = "", example = "f60f6ed5-a3e8-4489-9c42-b937bb5dac64")
		private String title;
		@Schema(description = "", example = "16ced65d-5536-4cf5-b96f-9b56d83a839a")
		private String message;
		@Schema(description = "", example = "b6c58555-5db1-4b46-bf25-9c1da975257f")
		private String status;
		@Schema(description = "", example = "ac99a264-fb0f-4419-9e5a-56b10eea5baf")
		private String reserved;
		@Schema(description = "", example = "024a3ae8-fb29-4cb9-84c1-75966436259a")
		private String errorMessage;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "786b601a-c104-4bc0-8bca-3a5ad247c6e3")
		private String reference;

}
