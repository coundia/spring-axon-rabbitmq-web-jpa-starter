package com.groupe2cs.bizyhub.products.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.List;

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

