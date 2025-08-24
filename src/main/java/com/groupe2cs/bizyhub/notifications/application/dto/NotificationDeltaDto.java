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

		@Schema(description = "", example = "de3359b6-c2df-443f-8adb-f80734249d85")
		private String deviceToken;
		@Schema(description = "", example = "6347f258-56fe-43a0-b604-19943d45d427")
		private String title;
		@Schema(description = "", example = "f59a5dc3-d999-4276-8519-c875b40fb2fb")
		private String message;
		@Schema(description = "", example = "4dfaca7d-acd5-459c-be39-e06ef476e520")
		private String status;
		@Schema(description = "", example = "33f4b126-ca97-4906-a6cd-7030d99b750c")
		private String remoteId;
		@Schema(description = "", example = "f52d2dde-e188-4a6c-bb37-b3c5e72183a1")
		private String localId;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "1eb18641-d2f4-4290-a370-6f9702cff5d6")
		private String reserved;
		@Schema(description = "", example = "1668aebe-9016-4380-92d1-d25cb6a64eeb")
		private String errorMessage;

}
