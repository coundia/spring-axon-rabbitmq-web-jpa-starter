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

		@Schema(description = "", example = "ff695ac8-84b8-4b9b-8b74-6ae1c4aab578")
		private String deviceToken;
		@Schema(description = "", example = "44160eb2-3490-45d6-8a7e-4ae421748550")
		private String title;
		@Schema(description = "", example = "3697146f-0504-4b8b-8a25-2bbea47e9936")
		private String message;
		@Schema(description = "", example = "a516e886-6181-4630-aa0b-f54334167eda")
		private String status;
		@Schema(description = "", example = "4278340d-272b-4eef-b2c9-182f62deed74")
		private String remoteId;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "f815336f-6302-4729-872c-acb760fa98f6")
		private String reserved;
		@Schema(description = "", example = "faf47495-4477-4946-ba94-af0b3f4890e2")
		private String errorMessage;

}
