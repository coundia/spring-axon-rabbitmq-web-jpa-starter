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

		@Schema(description = "", example = "1177fa06-34e4-4d38-b69a-17a6395ca337")
		private String deviceToken;
		@Schema(description = "", example = "ae012e8b-3c09-4f43-bd87-f68864a4da3e")
		private String title;
		@Schema(description = "", example = "9ff8396c-be1a-4b72-a246-adfb5b59fa77")
		private String message;
		@Schema(description = "", example = "a7f2c7a8-64dc-4871-a5e7-31cec2c21fa8")
		private String status;
		@Schema(description = "", example = "2f38f98b-8ae1-4eb6-89cb-65372069465e")
		private String remoteId;
		@Schema(description = "", example = "a1e0cf7d-36af-471f-a9bb-ab41df36242d")
		private String localId;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "c54f7fb1-4c77-4e2c-82cb-87f87ed909e5")
		private String reserved;
		@Schema(description = "", example = "833a4e59-21df-411a-b12e-5c5fbcf9a8ea")
		private String errorMessage;

}
