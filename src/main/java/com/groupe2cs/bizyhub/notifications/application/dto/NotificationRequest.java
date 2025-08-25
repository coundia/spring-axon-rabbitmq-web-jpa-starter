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

	@Schema(description = "", example = "db56b32a-79ab-4829-8644-a7b7b700d51f")
	private String deviceToken;
	@Schema(description = "", example = "2269d8db-22c0-4c4d-ae3d-3b2a998511b4")
	private String title;
	@Schema(description = "", example = "8a481d70-20e3-4dff-aa55-bbc277361e86")
	private String message;
	@Schema(description = "", example = "b1e123fa-2146-4154-b39b-22a6dfb7d264")
	private String status;
	@Schema(description = "", example = "cee9618b-ea1b-474e-aa8d-28f0fe459b9c")
	private String remoteId;
	@Schema(description = "", example = "728dd912-1312-4647-af8f-ceb6725daf04")
	private String localId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "458c7f20-39b3-4be3-9d34-3d214fe34a8c")
	private String reserved;
	@Schema(description = "", example = "5cf456d1-e6db-487a-ab09-4fc0f5150f33")
	private String errorMessage;

}
