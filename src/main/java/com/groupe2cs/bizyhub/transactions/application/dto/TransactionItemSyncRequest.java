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

@Schema(name = "TransactionItemSyncRequest", description = "Request payload for synchronizing transactionItems")
public class TransactionItemSyncRequest implements Serializable {

	@Schema(description = "Batch of transactionItem deltas")
	private List<TransactionItemDeltaDto> deltas;
}

