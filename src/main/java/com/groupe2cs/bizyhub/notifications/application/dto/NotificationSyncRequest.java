package com.groupe2cs.bizyhub.notifications.application.dto;

import java.util.List;
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
@Schema(name = "NotificationSyncRequest", description = "Request payload for synchronizing notifications")
public class NotificationSyncRequest implements Serializable {

@Schema(description = "Batch of notification deltas")
private List<NotificationDeltaDto> deltas;
	}

