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
@Schema(name = "TransactionSyncRequest", description = "Request payload for synchronizing transactions")
public class TransactionSyncRequest implements Serializable {

@Schema(description = "Batch of transaction deltas")
private List<TransactionDeltaDto> deltas;
	}

