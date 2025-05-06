package com.groupe2cs.bizyhub.sales.application.dto;

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
@Schema(name = "SaleUserSyncRequest", description = "Request payload for synchronizing saleusers")
public class SaleUserSyncRequest implements Serializable {

@Schema(description = "Batch of saleuser deltas")
private List<SaleUserDeltaDto> deltas;
	}

