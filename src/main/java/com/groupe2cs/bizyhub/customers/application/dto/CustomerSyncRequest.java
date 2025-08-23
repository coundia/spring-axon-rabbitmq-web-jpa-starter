package com.groupe2cs.bizyhub.customers.application.dto;

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

@Schema(name = "CustomerSyncRequest", description = "Request payload for synchronizing customers")
public class CustomerSyncRequest implements Serializable {

@Schema(description = "Batch of customer deltas")
private List<CustomerDeltaDto> deltas;
	}

