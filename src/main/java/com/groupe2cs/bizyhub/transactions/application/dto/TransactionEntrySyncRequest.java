package com.groupe2cs.bizyhub.transactions.application.dto;

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

@Schema(name = "TransactionEntrySyncRequest", description = "Request payload for synchronizing transactionEntrys")
public class TransactionEntrySyncRequest implements Serializable {

@Schema(description = "Batch of transactionEntry deltas")
private List<TransactionEntryDeltaDto> deltas;
	}

