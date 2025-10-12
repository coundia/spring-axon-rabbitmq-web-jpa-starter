package com.groupe2cs.bizyhub.stock.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.List;

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

