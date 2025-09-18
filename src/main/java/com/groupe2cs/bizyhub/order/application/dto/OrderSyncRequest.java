package com.groupe2cs.bizyhub.order.application.dto;

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

@Schema(name = "OrderSyncRequest", description = "Request payload for synchronizing orders")
public class OrderSyncRequest implements Serializable {

@Schema(description = "Batch of order deltas")
private List<OrderDeltaDto> deltas;
	}

