package com.groupe2cs.bizyhub.order.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Schema(name = "OrderSyncRequest", description = "Request payload for synchronizing orders")
public class OrderSyncRequest implements Serializable {

	@Schema(description = "Batch of order deltas")
	private List<OrderDeltaDto> deltas;
}

