package com.groupe2cs.bizyhub.balances.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "BalanceSyncRequest", description = "Request payload for synchronizing balances")
public class BalanceSyncRequest implements Serializable {

	@Schema(description = "Batch of balance deltas")
	private List<BalanceDeltaDto> deltas;
}

