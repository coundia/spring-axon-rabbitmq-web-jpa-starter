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

	@Schema(description = "", example = "5f3fded2-db76-44c0-8578-5930700ed516")
	private String deviceToken;
	@Schema(description = "", example = "6e6c1757-ebb1-4c9d-968f-3c0aeffb8d39")
	private String title;
	@Schema(description = "", example = "be5f00f1-b31e-4801-81c2-744d75cfa6ce")
	private String message;
	@Schema(description = "", example = "98590bb8-7f55-4b25-a430-f58aa71a3cf0")
	private String status;
	@Schema(description = "", example = "82c41c79-ba5d-4444-ad0f-2cb9fd481d9f")
	private String reserved;
	@Schema(description = "", example = "9acffe0f-5e4a-4874-8169-ee4c12a02904")
	private String errorMessage;

}
