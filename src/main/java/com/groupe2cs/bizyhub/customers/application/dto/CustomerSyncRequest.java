package com.groupe2cs.bizyhub.customers.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.List;

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

