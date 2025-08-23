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

	@Schema(description = "", example = "cecb7c1c-b58a-4ad6-ad21-03b6facd8334")
	private String deviceToken;
	@Schema(description = "", example = "bd305c32-216f-465a-91e9-b46105d29691")
	private String title;
	@Schema(description = "", example = "86292607-ac3c-4e31-b9d8-7a4c0c7934b5")
	private String message;
	@Schema(description = "", example = "d01b7ddf-8659-45d8-96d4-cb60bdc0b051")
	private String status;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "6feb5001-bdeb-4cdb-97c4-818631cfe859")
	private String reserved;
	@Schema(description = "", example = "02827e80-673b-446e-994f-e51effaa52da")
	private String errorMessage;

}
