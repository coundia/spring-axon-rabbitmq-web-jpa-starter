package com.groupe2cs.bizyhub.debts.application.dto;

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

@Schema(name = "DebtSyncRequest", description = "Request payload for synchronizing debts")
public class DebtSyncRequest implements Serializable {

@Schema(description = "Batch of debt deltas")
private List<DebtDeltaDto> deltas;
	}

