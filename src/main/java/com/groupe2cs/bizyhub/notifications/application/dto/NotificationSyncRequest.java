package com.groupe2cs.bizyhub.notifications.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Schema(name = "NotificationSyncRequest", description = "Request payload for synchronizing notifications")
public class NotificationSyncRequest implements Serializable {

	@Schema(description = "Batch of notification deltas")
	private List<NotificationDeltaDto> deltas;
}

