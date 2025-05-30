package com.groupe2cs.bizyhub.notifications.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

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

	@Schema(description = "", example = "dd4ee35a-ef48-4a65-b142-14d04a3508de")
	private String deviceToken;
	@Schema(description = "", example = "e4da0221-7c9e-45e4-bc8e-a36878a1a0ee")
	private String title;
	@Schema(description = "", example = "c511da7e-6685-4b7e-83a7-6545190455f1")
	private String message;
	@Schema(description = "", example = "caf5dfed-fda9-42bf-960f-f8c434657e97")
	private String status;
	@Schema(description = "", example = "98f25313-52af-410b-86f7-ed5d85d91e5c")
	private String reserved;
	@Schema(description = "", example = "e1fb119a-2e7a-42d9-b565-435da94e77f4")
	private String errorMessage;

}
