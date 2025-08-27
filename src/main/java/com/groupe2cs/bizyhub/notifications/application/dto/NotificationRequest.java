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

	@Schema(description = "", example = "b2c3a24a-a452-4545-bd47-6706ea02053d")
	private String deviceToken;
	@Schema(description = "", example = "b61814f5-0d41-47da-9d18-8ec694d0cd98")
	private String title;
	@Schema(description = "", example = "3c9ded08-3889-4ae5-b102-971c9cb651da")
	private String message;
	@Schema(description = "", example = "1d7b80a0-8ecd-4aa8-a7e6-b8960500f658")
	private String status;
	@Schema(description = "", example = "48cff2f7-662b-472f-89b8-cc9b305e7be8")
	private String remoteId;
	@Schema(description = "", example = "09df55e1-517f-4fa8-a1aa-a8fa542d0020")
	private String localId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "f8b450ff-f807-4e81-b0f6-846ac9c2642f")
	private String reserved;
	@Schema(description = "", example = "1ec04828-04b7-44d5-9763-be7697da7bb3")
	private String errorMessage;

}
