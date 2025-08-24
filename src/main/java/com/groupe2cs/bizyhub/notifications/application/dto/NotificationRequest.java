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

	@Schema(description = "", example = "be0ea782-5f90-4e42-96b7-89cd5877f9b4")
	private String deviceToken;
	@Schema(description = "", example = "0526efe1-b112-4bee-ad30-1890aa6a7d28")
	private String title;
	@Schema(description = "", example = "2643aa98-2c90-4b35-91db-7bf1568585df")
	private String message;
	@Schema(description = "", example = "4f9bbaac-f2b7-44c1-b22c-c7e3ebc6058c")
	private String status;
	@Schema(description = "", example = "d3eede98-f000-44aa-ad89-c28b2297a469")
	private String remoteId;
	@Schema(description = "", example = "a600284c-aaa4-4aa2-8847-fe4948e5bbe8")
	private String localId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "f5fe3531-98a4-40c2-8e06-5e19bed254cc")
	private String reserved;
	@Schema(description = "", example = "d5796752-2a2c-45af-b519-420336d1b70e")
	private String errorMessage;

}
