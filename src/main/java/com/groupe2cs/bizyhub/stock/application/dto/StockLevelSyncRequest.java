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

@Schema(name = "StockLevelSyncRequest", description = "Request payload for synchronizing stockLevels")
public class StockLevelSyncRequest implements Serializable {

	@Schema(description = "Batch of stockLevel deltas")
	private List<StockLevelDeltaDto> deltas;
}

