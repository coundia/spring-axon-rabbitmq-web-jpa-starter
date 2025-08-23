package com.groupe2cs.bizyhub.units.application.dto;

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

@Schema(name = "UnitSyncRequest", description = "Request payload for synchronizing units")
public class UnitSyncRequest implements Serializable {

@Schema(description = "Batch of unit deltas")
private List<UnitDeltaDto> deltas;
	}

