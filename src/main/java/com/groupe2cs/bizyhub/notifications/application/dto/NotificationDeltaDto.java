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

		@Schema(description = "", example = "9377c09c-a6a9-4bac-a8e1-2d43f8568191")
		private String deviceToken;
		@Schema(description = "", example = "361f0d67-9a7b-4798-b61a-30d52cf520a9")
		private String title;
		@Schema(description = "", example = "ffbaa790-74c2-4f46-9e9e-11ebf7619fe7")
		private String message;
		@Schema(description = "", example = "6b89350a-020e-4f5e-8b91-9dbd0876e1ea")
		private String status;
		@Schema(description = "", example = "c5159b27-b37e-4cbd-88b6-41344db0fc87")
		private String reserved;
		@Schema(description = "", example = "8d4ec4d1-6ca9-43d9-8c10-49a2446c8227")
		private String errorMessage;

}
