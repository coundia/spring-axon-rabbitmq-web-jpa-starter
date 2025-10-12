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

@Schema(name = "TransactionUserSyncRequest", description = "Request payload for synchronizing transactionUsers")
public class TransactionUserSyncRequest implements Serializable {

	@Schema(description = "Batch of transactionUser deltas")
	private List<TransactionUserDeltaDto> deltas;
}

