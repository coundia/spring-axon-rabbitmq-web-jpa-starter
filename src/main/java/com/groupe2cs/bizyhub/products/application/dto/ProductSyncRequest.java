package com.groupe2cs.bizyhub.products.application.dto;

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

@Schema(name = "ProductSyncRequest", description = "Request payload for synchronizing products")
public class ProductSyncRequest implements Serializable {

	@Schema(description = "Batch of product deltas")
	private List<ProductDeltaDto> deltas;
}

