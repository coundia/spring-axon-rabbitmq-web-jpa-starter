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

	@Schema(description = "", example = "c93874a4-9d6a-458f-8708-200980f57d3f")
	private String deviceToken;

	@Schema(description = "", example = "be5cfe9c-6e77-4af1-b9db-388b6787f83a")
	private String title;

	@Schema(description = "", example = "d89e3110-c566-4ed9-bb31-030b7d850ba7")
	private String message;

	@Schema(description = "", example = "812e919e-71ca-4e04-9a32-4722b309f7cf")
	private String status;

	@Schema(description = "", example = "14383fd8-ace9-48d8-9709-be7165819d36")
	private String reserved;

	@Schema(description = "", example = "97772a46-69eb-4a23-8e4d-f71060cd047e")
	private String errorMessage;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "3c004282-c734-4fb9-88b7-c82c7f024d60")
	private String reference;


}
