package com.groupe2cs.bizyhub.notifications.application.dto;

import com.groupe2cs.bizyhub.notifications.domain.valueObject.*;
import java.util.UUID;
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
@Schema(name = "NotificationRequest", description = "Request payload for Notification operations")
public class NotificationRequest implements Serializable {

	@Schema(description = "", example = "b89ec0f2-e537-45bd-a2e0-fe74964db321")
	private String deviceToken;
	@Schema(description = "", example = "5a375dc2-6a72-4766-977f-690e4a274479")
	private String title;
	@Schema(description = "", example = "4637fe76-1bfa-4096-982d-5b8ec632b8b7")
	private String message;
	@Schema(description = "", example = "7821df98-8e39-417d-9db5-7ba5d2ddd0ee")
	private String status;
	@Schema(description = "", example = "f5bc98d8-61d0-4a3a-bb12-e0cbe5742ba4")
	private String remoteId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "5f419c0b-906f-433b-ac88-716590b8158d")
	private String reserved;
	@Schema(description = "", example = "54fa24e3-9cc4-43d2-98a9-786b39a67745")
	private String errorMessage;

}
