package com.groupe2cs.bizyhub.notifications.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "NotificationResponse", description = "Response payload for Notification")
public class NotificationResponse implements Serializable {

	@Schema(description = "", example = "")
	private String id;
	@Schema(description = "", example = "")
	private String deviceToken;
	@Schema(description = "", example = "")
	private String title;
	@Schema(description = "", example = "")
	private String message;
	@Schema(description = "", example = "")
	private String status;
	@Schema(description = "", example = "")
	private String reserved;
	@Schema(description = "", example = "")
	private String errorMessage;
	@Schema(description = "", example = "")
	private String createdBy;
	@Schema(description = "", example = "")
	private String tenant;

}
