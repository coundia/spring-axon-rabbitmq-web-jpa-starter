package com.groupe2cs.bizyhub.debts.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Schema(name = "DebtSyncRequest", description = "Request payload for synchronizing debts")
public class DebtSyncRequest implements Serializable {

	@Schema(description = "Batch of debt deltas")
	private List<DebtDeltaDto> deltas;
}

