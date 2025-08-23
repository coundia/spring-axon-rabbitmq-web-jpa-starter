package com.groupe2cs.bizyhub.sync.application.dto;

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

@Schema(name = "SyncStateSyncRequest", description = "Request payload for synchronizing syncStates")
public class SyncStateSyncRequest implements Serializable {

@Schema(description = "Batch of syncState deltas")
private List<SyncStateDeltaDto> deltas;
	}

