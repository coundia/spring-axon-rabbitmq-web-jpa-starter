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

	@Schema(description = "", example = "b7bcdd7b-74d9-477e-bbfa-c3e5a3ee70c1")
	private String deviceToken;
	@Schema(description = "", example = "63035e5e-2d63-4732-a2cb-f06a0cf4e8e3")
	private String title;
	@Schema(description = "", example = "32a772ce-8fee-4190-8426-4b47c18f5e21")
	private String message;
	@Schema(description = "", example = "1b8525d2-4b9d-4a49-aa42-33e88ca6add6")
	private String status;
	@Schema(description = "", example = "d005082a-d6c5-4197-9a1d-fae1ec21d017")
	private String reserved;
	@Schema(description = "", example = "4254e968-7bce-462b-995d-af8cf8dd6472")
	private String errorMessage;

}
