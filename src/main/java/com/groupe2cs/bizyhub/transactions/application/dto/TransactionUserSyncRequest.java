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
@Schema(name = "TransactionUserSyncRequest", description = "Request payload for synchronizing transactionUsers")
public class TransactionUserSyncRequest implements Serializable {

@Schema(description = "Batch of transactionUser deltas")
private List<TransactionUserDeltaDto> deltas;
	}

