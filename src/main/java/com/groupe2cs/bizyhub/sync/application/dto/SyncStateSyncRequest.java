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

@Schema(name = "SyncStateSyncRequest", description = "Request payload for synchronizing syncStates")
public class SyncStateSyncRequest implements Serializable {

	@Schema(description = "Batch of syncState deltas")
	private List<SyncStateDeltaDto> deltas;
}

