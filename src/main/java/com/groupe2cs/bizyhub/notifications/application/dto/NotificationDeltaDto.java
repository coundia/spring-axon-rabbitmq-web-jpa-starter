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

		@Schema(description = "", example = "1474ce85-17e7-437e-b50b-60f0230b54b6")
		private String deviceToken;
		@Schema(description = "", example = "efcc30dd-a616-461c-bbac-750ab5b2b174")
		private String title;
		@Schema(description = "", example = "3ccc497e-d83c-422a-bfb0-275b7f1e97d2")
		private String message;
		@Schema(description = "", example = "79fb05cf-06b6-4446-b8f2-1b83c0d58e3f")
		private String status;
		@Schema(description = "", example = "90fa0bf5-a09e-4564-835d-920de0400494")
		private String remoteId;
		@Schema(description = "", example = "edb7aa10-6e91-4b69-be8a-fe6b0324f842")
		private String account;
		@Schema(description = "", example = "b951e7c4-be9e-48d8-a79c-e80fbf04ee69")
		private String localId;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "1e104f3d-6944-455a-b07f-5954dce4807e")
		private String reserved;
		@Schema(description = "", example = "145f4792-43ba-427a-962c-189412fef517")
		private String errorMessage;

}
