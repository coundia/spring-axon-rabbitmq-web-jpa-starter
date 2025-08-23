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

		@Schema(description = "", example = "d460d354-8327-43a8-affc-590bf01e9b0a")
		private String deviceToken;
		@Schema(description = "", example = "3b28ee93-cbc2-4958-8c0d-ba22a3a3610c")
		private String title;
		@Schema(description = "", example = "2a668021-8367-4fac-a98b-d66af233636e")
		private String message;
		@Schema(description = "", example = "46bfaf99-9bf9-4fca-bc66-f605946202f1")
		private String status;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "de639376-e859-45f8-8255-7e47b2f1ad31")
		private String reserved;
		@Schema(description = "", example = "07dfcd4d-1cfe-43d2-ab8b-d8db754b8a3d")
		private String errorMessage;

}
