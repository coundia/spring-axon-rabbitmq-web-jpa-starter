package com.groupe2cs.bizyhub.stock.application.dto;

import com.groupe2cs.bizyhub.stock.domain.valueObject.*;
import java.util.UUID;
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
@Schema(name = "StockMovementRequest", description = "Request payload for StockMovement operations")
public class StockMovementRequest implements Serializable {

	@Schema(description = "", example = "b7bff3fd-70f8-4fb2-ba0d-66a65fe86cf8")
	private String typeStockMovement;
	@Schema(description = "", example = "53")
	private Integer quantity;
	@Schema(description = "", example = "afad919d-91de-4edb-981f-fb0406a8c305")
	private String remoteId;
	@Schema(description = "", example = "c990539b-da96-4e78-a67e-907d8d1be5ec")
	private String localId;
	@Schema(description = "", example = "608789a6-6101-419f-9f32-d640ecbfbe17")
	private String account;
	@Schema(description = "", example = "96f5e025-fc65-43ba-ae65-aa93669d2986")
	private String company;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "cfd542c7-60f7-4e7c-9a54-0da06505d8dd")
	private String productVariant;
	@Schema(description = "", example = "357522ab-3781-4a5f-86af-f2dc0e4247f2")
	private String orderLineId;
	@Schema(description = "", example = "650b746a-2d31-440f-ba42-393a4941094a")
	private String discriminator;

}
