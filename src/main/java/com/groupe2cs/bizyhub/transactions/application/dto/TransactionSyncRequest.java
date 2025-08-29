package com.groupe2cs.bizyhub.transactions.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Schema(name = "TransactionSyncRequest", description = "Request payload for synchronizing transactions")
public class TransactionSyncRequest implements Serializable {

	@Schema(description = "Batch of transaction deltas")
	private List<TransactionDeltaDto> deltas;
}

