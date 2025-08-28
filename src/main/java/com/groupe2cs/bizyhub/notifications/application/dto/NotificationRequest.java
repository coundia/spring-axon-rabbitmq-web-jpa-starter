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

	@Schema(description = "", example = "a417da93-c06e-420d-871f-a290f97e5aa5")
	private String deviceToken;
	@Schema(description = "", example = "647a6efd-85b1-4e65-b999-2d7140a25a39")
	private String title;
	@Schema(description = "", example = "a04dd36c-5811-4aca-9896-057c3a2b9ae0")
	private String message;
	@Schema(description = "", example = "adcd9d24-7034-45c7-8b3c-84fadda1089a")
	private String status;
	@Schema(description = "", example = "2f453092-434b-40af-9b13-07e8400a69d8")
	private String remoteId;
	@Schema(description = "", example = "3790748e-7f1b-4e35-81dd-650edcc8733c")
	private String account;
	@Schema(description = "", example = "bae1ee96-a2f9-484a-adef-94280e742510")
	private String localId;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "c2eb4b28-244c-454f-a652-4095eef30464")
	private String reserved;
	@Schema(description = "", example = "d70cce68-1088-413a-a8d3-21d84bc0a576")
	private String errorMessage;

}
