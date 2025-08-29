package com.groupe2cs.bizyhub.sync.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Schema(name = "ChangeLogSyncRequest", description = "Request payload for synchronizing changeLogs")
public class ChangeLogSyncRequest implements Serializable {

	@Schema(description = "Batch of changeLog deltas")
	private List<ChangeLogDeltaDto> deltas;
}

