package com.groupe2cs.bizyhub.notifications.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

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

	@Schema(description = "", example = "6c412f30-aafc-41a2-b6b4-c1205ffa24db")
	private String deviceToken;
	@Schema(description = "", example = "60b237b9-f594-4583-bb0c-36a9efe58173")
	private String title;
	@Schema(description = "", example = "8217fbcb-544a-4dfa-9220-ceca37d1c874")
	private String message;
	@Schema(description = "", example = "00877258-f3cb-4e4b-a490-fe698e8e02b4")
	private String status;
	@Schema(description = "", example = "ad71e2f4-e1e4-4641-9f02-56fcb1885baa")
	private String remoteId;
	@Schema(description = "", example = "d8c81976-6b91-4cdc-8dde-d672b626a7ab")
	private String account;
	@Schema(description = "", example = "2b8f3fc7-308e-4482-9ee4-451f826e5cb2")
	private String localId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "92b05201-03b1-4e1d-a560-6f31fff53578")
	private String reserved;
	@Schema(description = "", example = "137719d3-2ef1-4218-964a-476361f84002")
	private String errorMessage;

}
