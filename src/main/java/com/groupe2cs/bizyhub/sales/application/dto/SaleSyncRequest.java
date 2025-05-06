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
@Schema(name = "SaleSyncRequest", description = "Request payload for synchronizing sales")
public class SaleSyncRequest implements Serializable {

@Schema(description = "Batch of sale deltas")
private List<SaleDeltaDto> deltas;
	}

