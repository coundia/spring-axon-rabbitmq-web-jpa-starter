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

@Schema(name = "StockLevelSyncRequest", description = "Request payload for synchronizing stockLevels")
public class StockLevelSyncRequest implements Serializable {

@Schema(description = "Batch of stockLevel deltas")
private List<StockLevelDeltaDto> deltas;
	}

