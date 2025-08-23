package com.groupe2cs.bizyhub.stock.application.dto;

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

@Schema(name = "StockMovementSyncRequest", description = "Request payload for synchronizing stockMovements")
public class StockMovementSyncRequest implements Serializable {

@Schema(description = "Batch of stockMovement deltas")
private List<StockMovementDeltaDto> deltas;
	}

